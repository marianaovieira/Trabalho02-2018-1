package br.iff.pooa20181.trabalho02_2018_1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import java.util.List;

import br.iff.pooa20181.trabalho02_2018_1.R;
import br.iff.pooa20181.trabalho02_2018_1.adapter.ClickRecyclerViewListener;
import br.iff.pooa20181.trabalho02_2018_1.adapter.EleitorAdapter;
import br.iff.pooa20181.trabalho02_2018_1.model.Eleitor;
import io.realm.Realm;

public class ListaEleitor extends AppCompatActivity implements ClickRecyclerViewListener {
    private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_eleitor);

        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaEleitor.this,EleitorDetalhe.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }

    protected void onResume() {

        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lista_eleitor);

        recyclerView.setAdapter(new EleitorAdapter(getEleitores(),this,this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Eleitor> getEleitores(){

        return (List) realm.where(Eleitor.class).findAll();

    }

    @Override
    public void onClick(Object object) {
        Eleitor eleitor = (Eleitor) object;
        Intent intent = new Intent(ListaEleitor.this,EleitorDetalhe.class);
        intent.putExtra("id",eleitor.getId());
        startActivity(intent);
    }



    public void finish(){
        super.finish();
        realm.close();
    }

}