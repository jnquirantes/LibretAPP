package com.app.programacion_multimedia;

import static com.app.programacion_multimedia.MainActivity.tema4;
import static com.app.programacion_multimedia.MainActivity.tema5;
import static com.app.programacion_multimedia.MainActivity.tema7;
import static com.app.programacion_multimedia.MainActivity.tema8;
import static com.app.programacion_multimedia.MainActivity.tema9;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.programacion_multimedia.tema4.T4_Actividad1;
import com.app.programacion_multimedia.tema7.T7_Actividad1;
import com.app.programacion_multimedia.tema8.vista.T8_Actividad1;

public class FragHecho extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_hecho, container, false);

        view.findViewById(R.id.bTarea).setOnClickListener(v -> {
            if(tema4 || tema5) {
                startActivity(new Intent(FragHecho.this.getContext(), T4_Actividad1.class));

            } else if (tema7) {
                Intent i = new Intent(FragHecho.this.getContext(), T7_Actividad1.class);
                i.putExtra("tema7", true);
                startActivity(i);

            } else if (tema8 || tema9) {
                startActivity(new Intent(FragHecho.this.getContext(), T8_Actividad1.class));
            }
        });

        return view;
    }
}