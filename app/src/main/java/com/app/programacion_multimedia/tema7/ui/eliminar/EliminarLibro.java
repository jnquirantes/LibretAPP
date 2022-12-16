package com.app.programacion_multimedia.tema7.ui.eliminar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.controller.BD_Controller;
import com.app.programacion_multimedia.databinding.T7Actividad2EliminarBinding;

public class EliminarLibro extends Fragment {

    private T7Actividad2EliminarBinding binding;
    private EditText etEliminar;
    private Button bEliminar;
    private BD_Controller bd;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.t7_actividad2_eliminar, container, false);

        etEliminar = v.findViewById(R.id.etEliminar);
        bEliminar = v.findViewById(R.id.bEliminar);

        bd = new BD_Controller(EliminarLibro.this.getContext());

        etEliminar.setText("");
        bEliminar.setOnClickListener(v1 -> {
            if(etEliminar.getText().toString().equals("")){
                etEliminar.setError("Introduce un ISBN");
                etEliminar.requestFocus();

            } else {
                String isbn = etEliminar.getText().toString();
                bd.eliminarLibro(isbn);
                //Toast.makeText(EliminarLibro.this.getContext(), "Libro eliminado", Toast.LENGTH_SHORT).show();

            }
        });
        return v;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}