package com.app.programacion_multimedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.programacion_multimedia.R;

import java.util.ArrayList;

public class T7_RecyclerLibros extends RecyclerView.Adapter<T7_RecyclerLibros.HolderList> {

        public static class HolderList extends RecyclerView.ViewHolder {

            TextView tNombre, tISBN;
            ImageView iLibro;

            public HolderList(@NonNull View itemView) {
                super(itemView);
                tNombre = itemView.findViewById(R.id.tNombre);
                tISBN = itemView.findViewById(R.id.tISBN);
                iLibro = itemView.findViewById(R.id.iLibro);

            }
        }

        private Context contexto;
        private ArrayList<String> nombres, ISBNs;
        private ArrayList<Integer> imagenes;

        public T7_RecyclerLibros(Context contexto, ArrayList<String> nombres, ArrayList<String> ISBNs,
                                 ArrayList<Integer> imagenes) {
            this.contexto = contexto;
            this.nombres = nombres;
            this.ISBNs = ISBNs;
            this.imagenes = imagenes;
        }

        public void refrescar() {notifyDataSetChanged();}

        @NonNull
        @Override
        public T7_RecyclerLibros.HolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.t7_actividad2_item_recycler, parent, false);
            return new T7_RecyclerLibros.HolderList(v);
        }

        @Override
        public void onBindViewHolder(@NonNull T7_RecyclerLibros.HolderList holder, int position) {
            holder.tNombre.setText(nombres.get(position));
            holder.tISBN.setText(ISBNs.get(position));
            holder.iLibro.setImageResource(imagenes.get(position));
        }

        @Override
        public int getItemCount() {
            return nombres.size();
        }

        @Override
        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
}
