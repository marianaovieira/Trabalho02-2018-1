package br.iff.pooa20181.trabalho02_2018_1.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.iff.pooa20181.trabalho02_2018_1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btEleitor = (Button) findViewById(R.id.btnCadastro_Eleitor);
        Button btCandidato = (Button) findViewById(R.id.btnCadastro_Candidato);

        btEleitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ListaEleitor.class);
                startActivity(intent);

            }
        });

       btCandidato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ListaCandidato.class);
                startActivity(intent);

            }
        });


    }
    private Context getContext(){
        return this;
    }

}
