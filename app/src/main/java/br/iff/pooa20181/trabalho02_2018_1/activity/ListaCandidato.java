package br.iff.pooa20181.trabalho02_2018_1.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.iff.pooa20181.trabalho02_2018_1.CandidatoDetalhe;
import br.iff.pooa20181.trabalho02_2018_1.R;
import io.realm.Realm;

public class ListaCandidato extends AppCompatActivity {

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

    }

