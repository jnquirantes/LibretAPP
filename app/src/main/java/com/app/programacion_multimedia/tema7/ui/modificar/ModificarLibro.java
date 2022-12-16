package com.app.programacion_multimedia.tema7.ui.modificar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.controller.BD_Controller;
import com.app.programacion_multimedia.databinding.T7Actividad2EliminarBinding;
import com.app.programacion_multimedia.tema7.T7_Actividad2_Libro;

public class ModificarLibro extends Fragment implements View.OnClickListener {

    private T7Actividad2EliminarBinding binding;
    private EditText etNombre, etDescripcion, etISBN;
    private Button bModificar, bCancelar;
    private ImageButton bBuscar;
    private BD_Controller bd;
    private String isbn, nombre, descripcion;
    private View pModificar;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.t7_actividad2_modificar, container, false);

        etNombre = v.findViewById(R.id.etNombre2);
        etDescripcion = v.findViewById(R.id.etDescripcion2);
        etISBN = v.findViewById(R.id.etISBN2);

        bModificar = v.findViewById(R.id.bModificar);
        bBuscar = v.findViewById(R.id.bBuscar2);
        bCancelar = v.findViewById(R.id.bCancelar2);

        bModificar.setOnClickListener(this);
        bBuscar.setOnClickListener(this);
        bCancelar.setOnClickListener(this);

        pModificar = v.findViewById(R.id.pModificar);

        clean();

        bd = new BD_Controller(ModificarLibro.this.getContext());

        return v;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case(R.id.bBuscar2):
                isbn = etISBN.getText().toString();

                if(isbn.equals("")) {
                    etISBN.setError("Introduce un ISBN");
                    etISBN.requestFocus();
                    return;

                } else {
                    T7_Actividad2_Libro libro = bd.consultarLibro(isbn);

                    if(libro != null) {
                        pModificar.setVisibility(View.VISIBLE);
                        etNombre.setText(libro.getNombre());
                        etDescripcion.setText(libro.getDescripcion());
                        etISBN.setEnabled(false);
                        bBuscar.setImageResource(R.drawable.ic_lock);
                        bBuscar.setEnabled(false);

                    } else {
                        etISBN.setError("ISBN no encontrado");
                        etISBN.requestFocus();
                    }

                }
            break;

            case(R.id.bCancelar2):
                pModificar.setVisibility(View.GONE);
                clean();
                etISBN.setEnabled(true);
                bBuscar.setImageResource(R.drawable.ic_search);
                bBuscar.setEnabled(true);
            break;

            case(R.id.bModificar):
                isbn = etISBN.getText().toString();
                nombre = etNombre.getText().toString();
                descripcion = etDescripcion.getText().toString();

                if(nombre.isEmpty()) {
                    etNombre.setError("Introduce un título");
                    etNombre.requestFocus();
                    return;
                }

                if(descripcion.isEmpty()) {
                    etDescripcion.setError("Introduce una descripción");
                    etDescripcion.requestFocus();
                    return;

                } else {
                    bd.modificarLibro(isbn, nombre, descripcion);
                    clean();
                }

            break;
        }
    }
    public void clean() {
        etNombre.setText("");
        etDescripcion.setText("");
        etISBN.setText("");

        isbn = etISBN.getText().toString();
        nombre = etNombre.getText().toString();
        descripcion = etDescripcion.getText().toString();

        etISBN.setEnabled(true);
        bBuscar.setImageResource(R.drawable.ic_search);
        bBuscar.setEnabled(true);
    }
@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}