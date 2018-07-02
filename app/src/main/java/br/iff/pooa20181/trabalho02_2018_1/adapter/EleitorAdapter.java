package br.iff.pooa20181.trabalho02_2018_1.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import br.iff.pooa20181.trabalho02_2018_1.R;
import br.iff.pooa20181.trabalho02_2018_1.model.Eleitor;


public class EleitorAdapter extends RecyclerView.Adapter {

    private List<Eleitor> eleitores;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;


    public EleitorAdapter(List<Eleitor> eleitores, Context context,ClickRecyclerViewListener clickRecyclerViewListener) {
        this.eleitores = eleitores;
        this.context = context;
        EleitorAdapter.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate( R.layout.activity_item_eleitor, parent, false);
        EleitorViewHolder eleitorViewHolder = new EleitorViewHolder(view);
        return eleitorViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        EleitorViewHolder eleitorHolder = (EleitorViewHolder) viewHolder;

        Eleitor eleitor  = this.eleitores.get(position) ;


        eleitorHolder.nomeEleitor.setText(eleitor.getNome());
        eleitorHolder.numeroTitulo.setText(eleitor.getNumero_titulo());
        eleitorHolder.zonaEleitoral.setText(eleitor.getZona_eleitoral());
        eleitorHolder.secaoEleitoral.setText(eleitor.getSecao_eleitoral());



    }

    @Override
    public int getItemCount() {
        return eleitores.size();
    }

    public class EleitorViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeEleitor;
        private final TextView numeroTitulo;
        private final TextView zonaEleitoral;
        private final TextView secaoEleitoral;

        public EleitorViewHolder(View itemView) {
            super(itemView);
            nomeEleitor = (TextView) itemView.findViewById(R.id.tvNomeEleitor);
            numeroTitulo = (TextView) itemView.findViewById(R.id.tvNumTitulo);
            zonaEleitoral = (TextView) itemView.findViewById(R.id.tvZonaEleitoral);
            secaoEleitoral = (TextView) itemView.findViewById(R.id.tvSecaoEleitoral);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick(eleitores.get(getLayoutPosition()));

                }
            });


        }
    }





}
