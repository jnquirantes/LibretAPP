package com.app.programacion_multimedia.tema7.ui.add;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.controller.BD_Controller;
import com.app.programacion_multimedia.databinding.T7Actividad2AddLibrosBinding;

public class AddLibros extends Fragment {

    private T7Actividad2AddLibrosBinding binding;
    private Button bAgregar;
    private EditText etNombre, etDescripcion, etISBN;
    private BD_Controller bd;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.t7_actividad2_add_libros, container, false);
        etNombre = v.findViewById(R.id.etNombre);
        etDescripcion = v.findViewById(R.id.etDescripcion);
        etISBN = v.findViewById(R.id.etISBN);
        bAgregar = v.findViewById(R.id.bAgregar);
        limpiar();

        bd = new BD_Controller(AddLibros.this.getContext());

        bAgregar.setOnClickListener(v1 -> {
            if(etNombre.getText().toString().equals("")) {
                etNombre.setError("Introduce un titulo");
                etNombre.requestFocus();
                return;
            }

            if (etDescripcion.getText().toString().equals("")) {
                etDescripcion.setError("Introduce una descripcion");
                etDescripcion.requestFocus();
                return;
            }

            if(etISBN.getText().toString().equals("")) {
                etISBN.setError("Introduce un ISBN");
                etISBN.requestFocus();
                return;
            }

            bd.insertarLibro(etNombre, etDescripcion, etISBN);
            limpiar();
        });

        return v;
    }

    public void limpiar(){
        etNombre.setText("");
        etDescripcion.setText("");
        etISBN.setText("");
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}