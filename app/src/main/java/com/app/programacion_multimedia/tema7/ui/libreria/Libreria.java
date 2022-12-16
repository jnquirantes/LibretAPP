package com.app.programacion_multimedia.tema7.ui.libreria;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.adapter.T7_RecyclerLibros;
import com.app.programacion_multimedia.controller.BD_Controller;
import com.app.programacion_multimedia.databinding.T7Actividad2LibreriaBinding;
import com.app.programacion_multimedia.tema7.T7_Actividad2;
import com.app.programacion_multimedia.tema7.T7_Actividad2_Libro;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Libreria extends Fragment {

    private T7Actividad2LibreriaBinding binding;
    private BD_Controller bd;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.t7_actividad2_libreria, container, false);

        RecyclerView recyclerLibros = v.findViewById(R.id.recyclerLibros);
        FloatingActionButton fabAgregar = v.findViewById(R.id.fabAgregar);
        bd = new BD_Controller(Libreria.this.getContext());

        fabAgregar.setOnClickListener(v1 -> {
            Intent i = new Intent(Libreria.this.getContext(), T7_Actividad2.class);
            i.putExtra("nuevo", true);
            startActivity(i);
        });

        ArrayList<T7_Actividad2_Libro> libros = new ArrayList<>(bd.consultar());

        T7_RecyclerLibros adapter = new T7_RecyclerLibros(Libreria.this.getContext(), libros);
        LinearLayoutManager llm = new LinearLayoutManager(Libreria.this.getContext());
        recyclerLibros.setLayoutManager(llm);
        recyclerLibros.setAdapter(adapter);
        adapter.refrescar();

        return v;

    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}