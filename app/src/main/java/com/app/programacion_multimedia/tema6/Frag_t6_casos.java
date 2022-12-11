package com.app.programacion_multimedia.tema6;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.app.programacion_multimedia.R;

public class Frag_t6_casos extends Fragment implements View.OnClickListener {

    private Button bCaso1_T6, bCaso2_T6, bCaso3_T6, bCaso4_T6, bCaso5_T6;

    public Frag_t6_casos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.t6_frag_casos, container, false);

        bCaso1_T6 = v.findViewById(R.id.bCaso1_T6);
        bCaso2_T6 = v.findViewById(R.id.bCaso2_T6);
        bCaso3_T6 = v.findViewById(R.id.bCaso3_T6);
        bCaso4_T6 = v.findViewById(R.id.bCaso4_T6);
        bCaso5_T6 = v.findViewById(R.id.bCaso5_T6);

        bCaso1_T6.setOnClickListener(this);
        bCaso2_T6.setOnClickListener(this);
        bCaso3_T6.setOnClickListener(this);
        bCaso4_T6.setOnClickListener(this);
        bCaso5_T6.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bCaso1_T6:
                startActivity(new Intent(Frag_t6_casos.this.getContext(), T6_Caso1.class));
            break;

            case R.id.bCaso2_T6:
                startActivity(new Intent(Frag_t6_casos.this.getContext(), T6_Caso2.class));
            break;

            case R.id.bCaso3_T6:
                startActivity(new Intent(Frag_t6_casos.this.getContext(), T6_Caso3.class));
            break;

            case R.id.bCaso4_T6:
                startActivity(new Intent(Frag_t6_casos.this.getContext(), T6_Caso4.class));
            break;

            case R.id.bCaso5_T6:
                startActivity(new Intent(Frag_t6_casos.this.getContext(), T6_Caso5.class));
                break;

        }
    }
}