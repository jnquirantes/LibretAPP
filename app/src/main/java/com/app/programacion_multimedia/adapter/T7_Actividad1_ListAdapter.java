package com.app.programacion_multimedia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.app.programacion_multimedia.R;

import java.util.ArrayList;

public class T7_Actividad1_ListAdapter extends BaseAdapter {

    private Context contexto;
    private ArrayList<String> ingredientes;

    public T7_Actividad1_ListAdapter(Context contexto, ArrayList<String> ingredientes) {
        super();
        this.contexto = contexto;
        this.ingredientes = ingredientes;
    }

    @Override
    public int getCount() {
        return ingredientes.size();
    }

    @Override
    public Object getItem(int i) {
        return ingredientes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(contexto).inflate(R.layout.t7_actividad1_item_ingredientes, null);
        TextView itemLista = view.findViewById(R.id.itemLista);

        String text = ingredientes.get(i);
        itemLista.setText(text);
        itemLista.setOnClickListener(view1 -> Toast.makeText(contexto, text, Toast.LENGTH_SHORT).show());

        return view;
    }

}
