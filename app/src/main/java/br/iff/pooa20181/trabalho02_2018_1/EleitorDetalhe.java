package br.iff.pooa20181.trabalho02_2018_1;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;

import br.iff.pooa20181.trabalho02_2018_1.model.Eleitor;
import io.realm.Realm;

public class EleitorDetalhe extends AppCompatActivity {

    EditText edNome, edNome_mae, edData, edNumeroTitulo, edZona, edCidade, edSecao;

    Button btnSalvar, btnAlterar, btnExcluir;

    int id;
    Eleitor eleitor;
    private Realm realm;

    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_eleitor_detalhe );

        edNome = (EditText) findViewById( R.id.txtNomeEleitor );
        edNome_mae = (EditText) findViewById( R.id.txtNomeMaeEleitor );
        edData = (EditText) findViewById( R.id.txtDataEleitor );
        edNumeroTitulo = (EditText) findViewById( R.id.txtNumeroTituloEleitor );
        edZona = (EditText) findViewById( R.id.txtZonaEleitor );
        edCidade = (EditText) findViewById( R.id.txtCidadeEleitor );
        edSecao = (EditText) findViewById( R.id.txtSecaoEleitor );

        btnSalvar = (Button) findViewById( R.id.btnSalvar );
        btnAlterar = (Button) findViewById( R.id.btnAlterar );
        btnExcluir = (Button) findViewById( R.id.btnExcluir );



        Intent intent = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

    }




}
