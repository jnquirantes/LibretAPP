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
import com.app.programacion_multimedia.tema7.T7_Actividad2_Libro;

import java.util.ArrayList;

public class T7_RecyclerLibros extends RecyclerView.Adapter<T7_RecyclerLibros.HolderList> {

        public static class HolderList extends RecyclerView.ViewHolder {

            TextView tTitulo, tDescripcion, tISBN;
            ImageView iLibro;

            public HolderList(@NonNull View itemView) {
                super(itemView);
                tTitulo = itemView.findViewById(R.id.tTitulo2);
                tDescripcion = itemView.findViewById(R.id.tDescripcion);
                tISBN = itemView.findViewById(R.id.tISBN2);
                iLibro = itemView.findViewById(R.id.iLibro);
            }
        }

        private Context contexto;
        private ArrayList<T7_Actividad2_Libro> libros;

        public T7_RecyclerLibros(Context contexto, ArrayList<T7_Actividad2_Libro> libros) {
            this.contexto = contexto;
            this.libros = libros;
        }

        public void refrescar() {notifyDataSetChanged();}

        @NonNull
        @Override
        public T7_RecyclerLibros.HolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.t7_item_libro, parent, false);
            return new T7_RecyclerLibros.HolderList(v);
        }

        @Override
        public void onBindViewHolder(@NonNull T7_RecyclerLibros.HolderList holder, int position) {
            holder.tTitulo.setText(libros.get(position).getNombre());
            holder.tDescripcion.setText(libros.get(position).getDescripcion());
            holder.tISBN.setText(libros.get(position).getISBN());
            //holder.iLibro.setImageResource(imagenes.get(position));
        }

        @Override
        public int getItemCount() {
            return libros.size();
        }

        @Override
        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
}
