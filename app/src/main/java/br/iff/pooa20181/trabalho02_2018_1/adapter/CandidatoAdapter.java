package br.iff.pooa20181.trabalho02_2018_1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.iff.pooa20181.trabalho02_2018_1.R;
import br.iff.pooa20181.trabalho02_2018_1.model.Candidato;


public class CandidatoAdapter extends RecyclerView.Adapter{

    private List<Candidato> candidatos;
    private Context context;
    private static ClickRecyclerViewListener clickRecyclerViewListener;

    public CandidatoAdapter(List<Candidato> candidatos, Context context,ClickRecyclerViewListener clickRecyclerViewListener) {
        this.candidatos = candidatos;
        this.context = context;
        this.clickRecyclerViewListener = clickRecyclerViewListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate( R.layout.activity_item_candidato, parent, false);
        CandidatoViewHolder eleitorViewHolder = new CandidatoViewHolder(view);
        return eleitorViewHolder;
    }


}
