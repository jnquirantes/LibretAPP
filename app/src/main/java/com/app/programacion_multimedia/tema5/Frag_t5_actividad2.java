package com.app.programacion_multimedia.tema5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.programacion_multimedia.R;

public class Frag_t5_actividad2 extends Fragment {

    public Frag_t5_actividad2() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.t5_frag_actividad2, container, false);

        return v;
    }
}