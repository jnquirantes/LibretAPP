package com.app.programacion_multimedia.tema7.ui.add;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.databinding.T7Actividad2AddLibrosBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AddLibros extends Fragment {

    private T7Actividad2AddLibrosBinding binding;
    private FloatingActionButton fabAgregar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.t7_actividad2_add_libros, container, false);


        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}