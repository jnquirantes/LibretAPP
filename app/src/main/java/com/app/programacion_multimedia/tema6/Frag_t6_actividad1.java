package com.app.programacion_multimedia.tema6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.app.programacion_multimedia.R;

public class Frag_t6_actividad1 extends Fragment implements View.OnClickListener{

    private ViewFlipper v_fliper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.t6_frag_actividad1, container, false);

        Button bPlay = v.findViewById(R.id.bPlay);
        Button bStop = v.findViewById(R.id.bStop);

        bPlay.setOnClickListener(this);
        bStop.setOnClickListener(this);

        int[] images = {R.drawable.img_otono, R.drawable.img_invierno, R.drawable.img_primavera, R.drawable.img_verano, R.drawable.img_universo};
        v_fliper = v.findViewById(R.id.v_flipper);

        for(int image: images){
            flipperImg(image);
        }

        return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case (R.id.bPlay):
                v_fliper.startFlipping();
            break;

            case (R.id.bStop):
                v_fliper.stopFlipping();
            break;
        }
    }

    public void flipperImg(int image){
        ImageView iv = new ImageView(Frag_t6_actividad1.this.getContext());
        iv.setBackgroundResource(image);

        v_fliper.addView(iv);
        v_fliper.setFlipInterval(3000);
        v_fliper.setAutoStart(true);
        v_fliper.setInAnimation(Frag_t6_actividad1.this.getContext(), android.R.anim.slide_in_left);
        v_fliper.setOutAnimation(Frag_t6_actividad1.this.getContext(), android.R.anim.slide_out_right);

    }
}