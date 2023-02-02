package com.app.programacion_multimedia.tema9;

import static com.app.programacion_multimedia.tema8.modelo.UtilidadesPHP.URL_SERVIDOR;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.tema8.modelo.User;
import com.app.programacion_multimedia.tema9.controlador.ControladorChistes;

import org.json.JSONException;
import org.json.JSONObject;

public class Frag_t9_actividad1 extends Fragment {

    private ImageView iChuck;
    private TextView tChiste;
    private String [] value;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_t9_actividad1, container, false);

        iChuck = v.findViewById(R.id.iChuck);
        tChiste = v.findViewById(R.id.tChiste);
        value = new String[1];

        iChuck.setOnClickListener(v1 -> {
            ControladorChistes.nuevoChiste(Frag_t9_actividad1.this.getContext(),value);
            tChiste.setText(value[0]);
        });
        return v;
    }
}