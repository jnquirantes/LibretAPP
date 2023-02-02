package com.app.programacion_multimedia.tema7.ui.add;

import static com.app.programacion_multimedia.MainActivity.tema7;
import static com.app.programacion_multimedia.MainActivity.tema8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.adapter.T7_Actividad1_ListAdapter;
import com.app.programacion_multimedia.controller.BD_Controller;
import com.app.programacion_multimedia.tema8.controlador.ControladorRecetas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddReceta extends Fragment implements View.OnClickListener {

    private EditText etTitulo, etPreparacion, etCategoria, etIngredientes;
    private ArrayList<String> ingredientes;
    private BD_Controller bd;
    private ListView lv;
    private T7_Actividad1_ListAdapter lvAdapter;
    private LinearLayout lyCategoria;
    private Button bAdd2;
    private FloatingActionButton fabAdd;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.t7_actividad1_add, container, false);
        etTitulo = view.findViewById(R.id.etTitulo);
        etPreparacion = view.findViewById(R.id.etPreparacion);
        etIngredientes = view.findViewById(R.id.etIngredientes);
        etCategoria = view.findViewById(R.id.etCategoria1);

        bAdd2 = view.findViewById(R.id.bAdd2);
        fabAdd = view.findViewById(R.id.fabAdd);
        bAdd2.setOnClickListener(this);
        fabAdd.setOnClickListener(this);

        lv = view.findViewById(R.id.lv);
        lyCategoria = view.findViewById(R.id.lyCategoria);

        if(tema8) {
            lyCategoria.setVisibility(View.VISIBLE);
            tema7 = false;

        } else {
            lyCategoria.setVisibility(View.GONE);
            tema8 = false;
        }

        etTitulo.setText("");
        etPreparacion.setText("");
        etIngredientes.setText("");

        ingredientes = new ArrayList<>();
        bd = new BD_Controller(AddReceta.this.getContext());

        return view;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case(R.id.bAdd2):
                if(!etIngredientes.getText().toString().equals("")) {
                    ingredientes.add(etIngredientes.getText().toString());
                    lvAdapter = new T7_Actividad1_ListAdapter(AddReceta.this.getContext(), ingredientes);
                    lv.setAdapter(lvAdapter);
                    etIngredientes.setText("");
                    etIngredientes.requestFocus();

                } else {
                    etIngredientes.setError("Introduce un ingrediente");
                    etIngredientes.requestFocus();
                }
            break;

            case(R.id.fabAdd):
                if(etTitulo.getText().toString().equals("")) {
                    etTitulo.setError("Introduce un título");
                    etTitulo.requestFocus();
                    return;
                }

                if (etPreparacion.getText().toString().equals("")) {
                    etPreparacion.setError("Introduce un modo de preparación");
                    etPreparacion.requestFocus();
                    return;
                }

                if(tema8 && etCategoria.getText().toString().equals("")) {
                    etCategoria.setError("Introduce una categoría");
                    etCategoria.requestFocus();
                }

                if(ingredientes.isEmpty()) {
                    etIngredientes.setError("Introduce al menos un ingrediente");
                    etIngredientes.requestFocus();
                    return;
                }

                if(tema7) {
                    bd.insertarRecetas(etTitulo, etPreparacion, ingredientes);
                    Toast.makeText(AddReceta.this.getContext(), "Receta añadida", Toast.LENGTH_SHORT).show();
                    etTitulo.setText("");
                    etPreparacion.setText("");
                    ingredientes.clear();
                    lv.setAdapter(lvAdapter);
                    bd.cerrarBD();

                } else if(tema8) {
                    ControladorRecetas.crearReceta(AddReceta.this.getContext(), etTitulo, etPreparacion, etCategoria, ingredientes);
                    etTitulo.setText("");
                    etPreparacion.setText("");
                    etCategoria.setText("");
                    ingredientes.clear();
                    lv.setAdapter(lvAdapter);
                }
            break;
        }
    }
}