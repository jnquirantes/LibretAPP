package com.app.programacion_multimedia.tema7.ui.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.adapter.T7_Actividad1_ListAdapter;
import com.app.programacion_multimedia.controller.BD_Controller;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddReceta extends Fragment {

    private EditText etTitulo, etPreparacion, etIngredientes;
    private ArrayList<String> ingredientes;
    private BD_Controller bd;
    private ListView lv;
    private T7_Actividad1_ListAdapter lvAdapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.t7_actividad1_add, container, false);
        etTitulo = view.findViewById(R.id.etTitulo);
        etPreparacion = view.findViewById(R.id.etPreparacion);
        etIngredientes = view.findViewById(R.id.etIngredientes);
        Button bAdd2 = view.findViewById(R.id.bAñadir);
        FloatingActionButton fabAdd = view.findViewById(R.id.fabAdd);
        lv = view.findViewById(R.id.lv);

        etTitulo.setText("");
        etPreparacion.setText("");
        etIngredientes.setText("");

        ingredientes = new ArrayList<>();
        bd = new BD_Controller(AddReceta.this.getContext());

        bAdd2.setOnClickListener(v -> {
            if(!etIngredientes.getText().toString().equals("")) {
                ingredientes.add(etIngredientes.getText().toString());
                lvAdapter = new T7_Actividad1_ListAdapter(AddReceta.this.getContext(), ingredientes);
                lv.setAdapter(lvAdapter);
                etIngredientes.setText("");
                etIngredientes.requestFocus();

            } else {
                etIngredientes.setError("Introduce un ingrediente");
                etIngredientes.requestFocus();            }
        });

        fabAdd.setOnClickListener(v -> {
            if(etTitulo.getText().toString().equals("")) {
                Toast.makeText(AddReceta.this.getContext(), "Introduce un titulo", Toast.LENGTH_SHORT).show();
                etTitulo.requestFocus();
                return;
            }

            if (etPreparacion.getText().toString().equals("")) {
                etPreparacion.setError("Introduce un modo de preparación");
                etPreparacion.requestFocus();
                return;
            }

            if(ingredientes.isEmpty()) {
                etIngredientes.setError("Introduce al menos un ingrediente");
                etIngredientes.requestFocus();
                return;
            }

            bd.insertarRecetas(etTitulo, etPreparacion, ingredientes);
            Toast.makeText(AddReceta.this.getContext(), "Receta añadida", Toast.LENGTH_SHORT).show();
            etTitulo.setText("");
            etPreparacion.setText("");
            ingredientes.clear();
            lv.setAdapter(lvAdapter);
            bd.cerrarBD();
        });

        return view;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}