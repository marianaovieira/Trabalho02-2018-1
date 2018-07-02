package br.iff.pooa20181.trabalho02_2018_1.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import br.iff.pooa20181.trabalho02_2018_1.R;
import br.iff.pooa20181.trabalho02_2018_1.adapter.CandidatoAdapter;
import br.iff.pooa20181.trabalho02_2018_1.adapter.ClickRecyclerViewListener;
import br.iff.pooa20181.trabalho02_2018_1.model.Candidato;
import io.realm.Realm;

public class ListaCandidato extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_lista_candidato );

        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( ListaCandidato.this, CandidatoDetalhe.class );

                intent.putExtra( "id", 0 );
                startActivity( intent );
            }
        } );
    }

    Context context;

    protected void onResume() {
        super.onResume();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.lista_candidato);


        recyclerView.setAdapter(new CandidatoAdapter(getCandidatos(),this,this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    public List getCandidatos(){

        return (List) realm.where(Candidato.class).findAll();

    }

    @Override
    public void onClick(Object object) {
        Candidato candidato = (Candidato) object;
        Intent intent = new Intent(ListaCandidato.this,CandidatoDetalhe.class);
        intent.putExtra("id",candidato.getId());
        startActivity(intent);
    }

    public void finish(){
        super.finish();
        realm.close();
    }

    }

