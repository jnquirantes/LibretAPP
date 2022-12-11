package com.app.programacion_multimedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.programacion_multimedia.R;

import java.util.ArrayList;

public class T7_RecyclerRecetas extends RecyclerView.Adapter<T7_RecyclerRecetas.HolderList> {

    public static class HolderList extends RecyclerView.ViewHolder {

        TextView tTitulo;

        public HolderList(@NonNull View itemView) {
            super(itemView);
            tTitulo = itemView.findViewById(R.id.tTitulo);
        }
    }

    private Context contexto;
    private ArrayList<String> titulos;

    public T7_RecyclerRecetas(Context contexto, ArrayList<String> titulos) {
        this.contexto = contexto;
        this.titulos = titulos;
    }

    public void refrescar() {notifyDataSetChanged();}

    @NonNull
    @Override
    public T7_RecyclerRecetas.HolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.t7_actividad1_item_recycler, parent, false);
        return new HolderList(v);
    }

    @Override
    public void onBindViewHolder(@NonNull T7_RecyclerRecetas.HolderList holder, int position) {
       holder.tTitulo.setText(titulos.get(position));
    }

    @Override
    public int getItemCount() {
        return titulos.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
