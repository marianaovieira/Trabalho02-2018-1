package br.iff.pooa20181.trabalho02_2018_1.activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.iff.pooa20181.trabalho02_2018_1.R;
import br.iff.pooa20181.trabalho02_2018_1.model.Candidato;
import io.realm.Realm;

public class CandidatoDetalhe extends AppCompatActivity {

    EditText edNomeCandidato, edPartido, edNumeroUrna, edCargo, edNumeroVotos, edEstado, edCidade;
    Button btnSalvar, btnAlterar, btnExcluir;

    int id;
    Candidato candidato;
    private Realm realm;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_candidato_detalhe );

        edNomeCandidato = (EditText) findViewById(R.id.txtNomeCandidato);
        edPartido = (EditText) findViewById(R.id.txtPartidoCandidato);
        edNumeroUrna = (EditText) findViewById(R.id.txtNumeroUrna);
        edCargo = (EditText) findViewById(R.id.txtCargoCandidato);
        edNumeroVotos = (EditText) findViewById(R.id.txtVotosCandidato);
        edEstado = (EditText) findViewById(R.id.txtEstadoCandidato);
        edCidade = (EditText) findViewById(R.id.txtCidadeCandidato);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnAlterar = (Button) findViewById(R.id.btnAlterar);
        btnExcluir = (Button) findViewById(R.id.btnExcluir);

        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();



        if(id != 0)
        {

            btnSalvar.setEnabled(false);
            btnSalvar.setClickable(false);
            btnSalvar.setVisibility(View.INVISIBLE);

            btnAlterar.setEnabled(true);
            btnAlterar.setClickable(true);
            btnAlterar.setVisibility( View.VISIBLE);


            candidato = realm.where(Candidato.class).equalTo("id",id).findFirst();

            edNomeCandidato.setText(candidato.getNome());
            edPartido.setText(candidato.getPartido());
            edNumeroUrna.setText(candidato.getNumero_urna());
            edCargo.setText(candidato.getCargo());
            edNumeroVotos.setText(candidato.getNumero_votos());
            edEstado.setText(candidato.getEstado());
            edCidade.setText(candidato.getCidade());
        }
        else
        {
            btnAlterar.setEnabled(false);
            btnAlterar.setClickable(false);
            btnAlterar.setVisibility(View.INVISIBLE);
            btnExcluir.setEnabled(false);
            btnExcluir.setClickable(false);
            btnExcluir.setVisibility(View.INVISIBLE);
        }

        btnSalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        btnAlterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });


        btnExcluir.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                deletar();
            }
        });
    }


    public void salvar() {


        int proximoID = 1;
        if(realm.where(Candidato.class).max("id") !=null)
            proximoID = realm.where(Candidato.class).max("id").intValue()+1;

        realm.beginTransaction();
        Candidato candidato = new Candidato();
        candidato.setId(proximoID);
        setEGrava(candidato);

        realm.copyToRealm(candidato);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Candidato cadastrado!",Toast.LENGTH_LONG).show();
        this.finish();

    }

    private void setEGrava(Candidato candidato){

        candidato.setNome(edNomeCandidato.getText().toString());
        candidato.setPartido(edPartido.getText().toString());
        candidato.setNumero_urna(edNumeroUrna.getText().toString());
        candidato.setCargo(edCargo.getText().toString());
        candidato.setNumero_votos(edNumeroVotos.getText().toString());
        candidato.setEstado(edEstado.getText().toString());
        candidato.setCidade(edCidade.getText().toString());

    }

    public void alterar() {

        realm.beginTransaction();

        setEGrava(candidato);

        realm.copyToRealm(candidato);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Candidato alterado!",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void deletar(){
        realm.beginTransaction();
        candidato.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Candidato deletado!", Toast.LENGTH_LONG).show();
        this.finish();

    }
}
