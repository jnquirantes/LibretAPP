package com.app.programacion_multimedia;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.programacion_multimedia.tema4.T4_Actividad1;
import com.app.programacion_multimedia.tema7.T7_Actividad1;
import com.app.programacion_multimedia.tema7.T7_Actividad2;
import com.app.programacion_multimedia.tema7.Tema7;

public class FragHecho extends Fragment {

    private boolean tema4 = MainActivity.tema4;
    private boolean tema5 = MainActivity.tema5;
    private boolean tema6 = MainActivity.tema6;
    private boolean tema7 = MainActivity.tema7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_hecho, container, false);

        view.findViewById(R.id.bTarea).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tema4 || tema5) {
                    startActivity(new Intent(FragHecho.this.getContext(), T4_Actividad1.class));

                } else if (tema7) {
                    startActivity(new Intent(FragHecho.this.getContext(), T7_Actividad1.class));

                }
            }
        });

        return view;
    }
}