package com.app.programacion_multimedia.tema7.ui.modificar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.databinding.T7Actividad2EliminarBinding;

public class ModificarLibro extends Fragment {

    private T7Actividad2EliminarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.t7_actividad2_modificar, container, false);

        return v;
    }

@Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}