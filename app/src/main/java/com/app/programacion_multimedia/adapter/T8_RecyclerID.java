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
import com.app.programacion_multimedia.tema8.modelo.User;

import java.util.ArrayList;

public class T8_RecyclerID extends RecyclerView.Adapter<T8_RecyclerID.HolderList> {

    public static class HolderList extends RecyclerView.ViewHolder {

        TextView tID, tUser, tPass;
        ImageView ivUser;

        public HolderList(@NonNull View itemView) {
            super(itemView);
            tID = itemView.findViewById(R.id.tID);
            tUser = itemView.findViewById(R.id.tUser);
            ivUser = itemView.findViewById(R.id.ivUser);
            tPass = itemView.findViewById(R.id.tPass);
        }
    }

    private Context contexto;
    private ArrayList<User> users;

    public T8_RecyclerID(Context contexto, ArrayList<User> users) {
        this.contexto = contexto;
        this.users = users;
    }

    public void refrescar() {notifyDataSetChanged();}

    @NonNull
    @Override
    public T8_RecyclerID.HolderList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.t8_actividad1_item_user, parent, false);
        return new T8_RecyclerID.HolderList(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderList holder, int position) {
        holder.tID.setText(String.valueOf(users.get(position).getID()));
        holder.tUser.setText(users.get(position).getUser());
        holder.tPass.setText(users.get(position).getPass());
        holder.ivUser.setImageResource(R.drawable.ic_users);
    }

    public void clear() {
        users.clear();
    }
    @Override
    public int getItemCount() {
        return users.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}