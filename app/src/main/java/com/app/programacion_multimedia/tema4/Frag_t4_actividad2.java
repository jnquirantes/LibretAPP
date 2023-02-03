package com.app.programacion_multimedia.tema4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.app.programacion_multimedia.R;

public class Frag_t4_actividad2 extends Fragment {

    private EditText etURL;
    private String ruta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.t4_frag_actividad2, container, false);

        etURL = view.findViewById(R.id.etURL);

        view.findViewById(R.id.bBuscar).setOnClickListener(v -> {
            ruta = etURL.getText().toString().trim();
            if (!Patterns.WEB_URL.matcher(ruta).matches()) {
                Toast.makeText(Frag_t4_actividad2.this.getContext(), "Introduzca una URL correcta", Toast.LENGTH_SHORT).show();
                etURL.requestFocus();
                return;

            } else {
                ruta = "http:\\" + etURL.getText().toString().trim();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(ruta));
                startActivity(intent);
            }

        });

        return view;
    }
}