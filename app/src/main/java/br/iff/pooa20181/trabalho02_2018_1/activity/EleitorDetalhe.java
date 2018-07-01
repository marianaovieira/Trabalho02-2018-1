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
import br.iff.pooa20181.trabalho02_2018_1.model.Eleitor;
import io.realm.Realm;

public class EleitorDetalhe extends AppCompatActivity {

    EditText edNome, edNome_mae, edData, edNumeroTitulo, edZona, edCidade, edSecao;

    Button btnSalvar, btnAlterar, btnExcluir;

    int id;
    Eleitor eleitor;
    private Realm realm;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_eleitor_detalhe );

        edNome = (EditText) findViewById( R.id.txtNomeCandidato );
        edNome_mae = (EditText) findViewById( R.id.txtPartidoCandidato );
        edData = (EditText) findViewById( R.id.txtNumeroUrna );
        edNumeroTitulo = (EditText) findViewById( R.id.txtCargoCandidato );
        edZona = (EditText) findViewById( R.id.txtVotosCandidato );
        edCidade = (EditText) findViewById( R.id.txtCidadeCandidato );
        edSecao = (EditText) findViewById( R.id.txtSecaoEleitor );

        btnSalvar = (Button) findViewById( R.id.btnSalvar );
        btnAlterar = (Button) findViewById( R.id.btnAlterar );
        btnExcluir = (Button) findViewById( R.id.btnExcluir );



        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();


        if(id != 0)
        {

            btnSalvar.setEnabled(false);
            btnSalvar.setClickable(false);
            btnSalvar.setVisibility( View.INVISIBLE);

            btnAlterar.setEnabled(true);
            btnAlterar.setClickable(true);
            btnAlterar.setVisibility(View.VISIBLE);


            eleitor = realm.where(Eleitor.class).equalTo("id",id).findFirst();

            edNome.setText(eleitor.getNome());
            edNome_mae.setText(eleitor.getNome_mae());
            edNumeroTitulo.setText(eleitor.getNumero_titulo());
            edData.setText(eleitor.getData_nascimento());
            edSecao.setText(eleitor.getSecao_eleitoral());
            edZona.setText(eleitor.getZona_eleitoral());
            edCidade.setText(eleitor.getCidade());
        } else
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


    public void deletar(){
        realm.beginTransaction();
        eleitor.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Eleitor deletado com sucesso",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Eleitor.class).max("id") !=null)
            proximoID = realm.where(Eleitor.class).max("id").intValue()+1;

        realm.beginTransaction();
        Eleitor eleitor = new Eleitor();
        eleitor.setId(proximoID);
        setEGrava(eleitor);

        realm.copyToRealm(eleitor);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Eleitor cadastrado!",Toast.LENGTH_LONG).show();
        this.finish();

    }

    private void setEGrava(Eleitor eleitor){

        eleitor.setNome(edNome.getText().toString());
        eleitor.setNome_mae(edNome_mae.getText().toString());
        eleitor.setNumero_titulo(edNumeroTitulo.getText().toString());
        eleitor.setSecao_eleitoral(edSecao.getText().toString());
        eleitor.setZona_eleitoral(edZona.getText().toString());
        eleitor.setCidade(edCidade.getText().toString());
        eleitor.setData_nascimento(edData.getText().toString());



    }

    public void alterar() {

        realm.beginTransaction();

        setEGrava(eleitor);

        realm.copyToRealm(eleitor);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Eleitor alterado!",Toast.LENGTH_LONG).show();
        this.finish();

    }
}





