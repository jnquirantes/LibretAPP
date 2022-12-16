package com.app.programacion_multimedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.tema5.ElementoLista;

import java.util.ArrayList;

public class T5_ListAdapter extends RecyclerView.Adapter<T5_ListAdapter.HolderList> {

    public static class HolderList extends RecyclerView.ViewHolder {

        TextView tUno, tDos;

        public HolderList(@NonNull View itemView) {
            super(itemView);
            tUno = itemView.findViewById(R.id.tUno);
            tDos = itemView.findViewById(R.id.tDos);
        }
    }

    private Context contexto;
    private ArrayList<ElementoLista> elementos;

    public T5_ListAdapter(Context contexto, ArrayList<ElementoLista> elementos) {
        this.elementos = elementos;
        this.contexto = contexto;
    }

    public void add(ArrayList<ElementoLista> datos){
        elementos.clear();
        elementos.addAll(datos);
    }

    public void refrescar() {notifyDataSetChanged();}

    @NonNull
    @Override
    public T5_ListAdapter.HolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.t5_elemento_lista, parent, false);
        return new HolderList(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderList elementoActual, int position) {
        elementoActual.tUno.setText(elementos.get(position).getTexto1());
        elementoActual.tDos.setText(elementos.get(position).getTexto2());
    }

    @Override
    public int getItemCount() {return elementos.size();}

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
