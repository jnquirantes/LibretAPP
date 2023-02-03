package com.app.programacion_multimedia.tema10;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.programacion_multimedia.R;

import java.util.regex.Pattern;

public class Frag_t10_Actividad1 extends Fragment {

    private EditText etMarcador, etLatitud, etLongitud;
    private Button bMarcar;
    protected static String marcador, latitud, longitud;
    protected static boolean enviado = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_t10__actividad1, container, false);

        etMarcador = v.findViewById(R.id.etMarcador);
        etLatitud = v.findViewById(R.id.etLatitud);
        etLongitud = v.findViewById(R.id.etLongitud);
        bMarcar = v.findViewById(R.id.bMarcar);

        clean();

        bMarcar.setOnClickListener(v1 -> {
            marcador = etMarcador.getText().toString();
            latitud = etLatitud.getText().toString();
            longitud = etLongitud.getText().toString();

            if(marcador.equals("")) {
                etMarcador.setError("Introduzca un título");
                etMarcador.requestFocus();
                return;
            }

            if(latitud.equals("")) {
                etLatitud.setError("Introduzca una latitud");
                etLatitud.requestFocus();
                return;
            } else {
                String regexLat = "^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$";
                if(!Pattern.matches(regexLat, latitud)) {
                    etLatitud.setError("Formato de latitud incorrecto");
                    etLatitud.requestFocus();
                    return;
                }

            }

            if(longitud.equals("")) {
                etLongitud.setError("Introduzca una longitud");
                etLongitud.requestFocus();
                return;

            } else {
                String regexLat = "^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$";
                if(!Pattern.matches(regexLat, longitud)) {
                    etLongitud.setError("Formato de longitud incorrecto");
                    etLongitud.requestFocus();
                    return;

                } else {
                    Intent i = new Intent(Frag_t10_Actividad1.this.getContext(), Tema10.class);
                    i.putExtra("marcador", marcador);
                    i.putExtra("latitud", latitud);
                    i.putExtra("longitud", longitud);
                    enviado = true;
                    startActivity(i);
                }
            }


        });

        return v;

    }

    public void clean() {
        etMarcador.setText("");
        etLatitud.setText("");
        etLongitud.setText("");
    }
}