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
import com.app.programacion_multimedia.tema8.Pescado;

import java.util.ArrayList;

public class T8_RecyclerPeces extends RecyclerView.Adapter<T8_RecyclerPeces.HolderList> {

    public static class HolderList extends RecyclerView.ViewHolder {

        TextView tName, tSize, tType, tPrice;
        ImageView ivFish;

        public HolderList(@NonNull View itemView) {
            super(itemView);
            tName = itemView.findViewById(R.id.tName);
            tType = itemView.findViewById(R.id.tType);
            tSize = itemView.findViewById(R.id.tSize);
            tPrice = itemView.findViewById(R.id.tPrice);
            ivFish = itemView.findViewById(R.id.ivFish);
        }
    }

    private Context contexto;
    private ArrayList<Pescado> pescados;

    public T8_RecyclerPeces(Context contexto, ArrayList<Pescado> pescados) {
        this.contexto = contexto;
        this.pescados = pescados;

    }

    public void refrescar() {notifyDataSetChanged();}

    @NonNull
    @Override
    public T8_RecyclerPeces.HolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.t8_caso_item_recycler, parent, false);
        return new T8_RecyclerPeces.HolderList(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderList holder, int position) {
        holder.tName.setText(pescados.get(position).getNombre());
        holder.tType.setText(pescados.get(position).getTipo());
        holder.tSize.setText(pescados.get(position).getTamaño());
        holder.tPrice.setText(String.valueOf(pescados.get(position).getPrecio()));
        holder.ivFish.setImageResource(R.drawable.ic_orange_fish);
    }

    @Override
    public int getItemCount() {
        return pescados.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
