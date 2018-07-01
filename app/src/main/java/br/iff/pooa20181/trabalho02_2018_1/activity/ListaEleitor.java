import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toolbar;

import br.iff.pooa20181.trabalho02_2018_1.R;
import io.realm.Realm;

public class ListagemEleitorActivity extends AppCompatActivity implements ClickRecyclerViewListener {

    private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_eleitor);


        realm = Realm.getDefaultInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListagemEleitorActivity.this,EleitorDetalhe.class);

                intent.putExtra("id",0);
                startActivity(intent);
            }
        });
    }