package com.app.programacion_multimedia.tema5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.adapter.T5_ListAdapter;

import java.util.ArrayList;

public class Frag_t5_caso extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.t5_frag_caso, container, false);

        RecyclerView listaEjemplo = v.findViewById(R.id.listaEjemplo);

        ArrayList<ElementoLista> elementos =  new ArrayList<>();

        for(int i=0; i<20; i++){
            ElementoLista elemento = new ElementoLista("Elemento " + i + ": T1", "Elemento " + i + ": T2");
            elementos.add(elemento);
        }

        listaEjemplo.setHasFixedSize(false);

        LinearLayoutManager llm = new LinearLayoutManager(Frag_t5_caso.this.getContext());
        //LinearLayoutManager llm = new GridLayoutManager(Frag_t5_caso.this.getContext(), 3);
        listaEjemplo.setLayoutManager(llm);

        T5_ListAdapter la = new T5_ListAdapter(Frag_t5_caso.this.getContext(), elementos);
        listaEjemplo.setAdapter(la);
        la.refrescar();


        return v;
    }
}