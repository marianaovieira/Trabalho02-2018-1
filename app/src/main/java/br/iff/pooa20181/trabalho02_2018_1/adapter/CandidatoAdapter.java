package br.iff.pooa20181.trabalho02_2018_1.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.iff.pooa20181.trabalho02_2018_1.R;
import br.iff.pooa20181.trabalho02_2018_1.model.Candidato;

import static br.iff.pooa20181.trabalho02_2018_1.R.layout.activity_item_candidato;


public class CandidatoAdapter extends RecyclerView.Adapter {

    private List<Candidato> candidatos;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public CandidatoAdapter(List<Candidato> candidatos, Context context, ClickRecyclerViewListener clickRecyclerViewListener) {
        this.candidatos = candidatos;
        this.context = context;
        CandidatoAdapter.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( context )
                .inflate( activity_item_candidato, parent, false );
        CandidatoViewHolder candidatoViewHolder = new CandidatoViewHolder( view );
        return candidatoViewHolder;

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        CandidatoViewHolder candidatoHolder = (CandidatoViewHolder) viewHolder;

        Candidato candidato = this.candidatos.get( position );


        candidatoHolder.nomeCandidato.setText( candidato.getNome() );
        candidatoHolder.partidoCandidato.setText( candidato.getPartido() );
        candidatoHolder.numeroUrna.setText( candidato.getNumero_urna() );
        candidatoHolder.cargoCandidato.setText( candidato.getCargo() );


    }

    @Override
    public int getItemCount() {
        return candidatos.size();
    }

    public class CandidatoViewHolder extends RecyclerView.ViewHolder {

        private final TextView nomeCandidato;
        private final TextView partidoCandidato;
        private final TextView numeroUrna;
        private final TextView cargoCandidato;

        public CandidatoViewHolder(View itemView) {

            super( itemView );

            nomeCandidato = (TextView) itemView.findViewById( R.id.tvNomeCandidato );
            partidoCandidato = (TextView) itemView.findViewById( R.id.tvPartido );
            numeroUrna = (TextView) itemView.findViewById( R.id.tvNumeroUrna );
            cargoCandidato = (TextView) itemView.findViewById( R.id.tvCargo );

            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecyclerViewListener.onClick( candidatos.get( getLayoutPosition() ) );

                }
            } );


        }
    }
}
