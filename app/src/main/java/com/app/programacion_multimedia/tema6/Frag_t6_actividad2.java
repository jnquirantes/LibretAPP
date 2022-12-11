package com.app.programacion_multimedia.tema6;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.amrdeveloper.reactbutton.ReactButton;
import com.app.programacion_multimedia.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;


public class Frag_t6_actividad2 extends Fragment implements View.OnClickListener {

    private ReactButton bReaccion, bComentar, bCompartir;
    private EditText etComentar;
    private Button bAceptar, bCancelar;
    private TextView tComentario;
    private FloatingActionButton fabPrevious, fabNext;
    int images[] = {R.drawable.img_otono, R.drawable.img_invierno, R.drawable.img_primavera, R.drawable.img_verano, R.drawable.img_universo};
    private CircleImageView civ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.t6_frag_actividad2, container, false);

        bReaccion = v.findViewById(R.id.bReaccion);
        bComentar = v.findViewById(R.id.bComentar);
        bCompartir = v.findViewById(R.id.bCompartir);
        etComentar = v.findViewById(R.id.etComentar);
        bAceptar = v.findViewById(R.id.bAceptar);
        bCancelar = v.findViewById(R.id.bCancelar);
        tComentario = v.findViewById(R.id.tComentario);
        fabPrevious = v.findViewById(R.id.fabPrevious);
        fabNext = v.findViewById(R.id.fabNext);
        civ = v.findViewById(R.id.profileImage);

        civ.setImageResource(images[0]);

        bComentar.setOnClickListener(this);
        bAceptar.setOnClickListener(this);
        bCancelar.setOnClickListener(this);
        fabPrevious.setOnClickListener(this);
        fabNext.setOnClickListener(this);

        bReaccion.setDefaultReaction(T6_FbReaction.defaultReact);
        bReaccion.setReactions(T6_FbReaction.reactions);
        bReaccion.setEnableReactionTooltip(true);

        bComentar.setDefaultReaction(T6_FbReaction.defaultComment);
        bComentar.setReactions(T6_FbReaction.comentar);
        bComentar.setEnableReactionTooltip(true);

        bCompartir.setDefaultReaction(T6_FbReaction.defaultShare);
        bCompartir.setReactions(T6_FbReaction.compartir);

        return v;
    }

    boolean count = true;
    int aux = 0;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.bComentar):
                if(count){
                    etComentar.setVisibility(View.VISIBLE);
                    bAceptar.setVisibility(View.VISIBLE);
                    bCancelar.setVisibility(View.VISIBLE);
                    bComentar.setTextColor(Color.GREEN);

                    bComentar.setCurrentReaction(T6_FbReaction.comentar[0]);
                    count = false;

                } else {
                    etComentar.setVisibility(View.GONE);
                    bAceptar.setVisibility(View.GONE);
                    bCancelar.setVisibility(View.GONE);
                    bComentar.setCurrentReaction(T6_FbReaction.defaultComment);
                    count = true;
                }
            break;

            case(R.id.bAceptar):
                etComentar.setVisibility(View.GONE);
                bAceptar.setVisibility(View.GONE);
                bCancelar.setVisibility(View.GONE);
                tComentario.setText(etComentar.getText().toString());
            break;

            case(R.id.bCancelar):
                etComentar.setVisibility(View.GONE);
                bAceptar.setVisibility(View.GONE);
                bCancelar.setVisibility(View.GONE);
                count = true;
            break;

            case(R.id.bCompartir):
                bComentar.setCurrentReaction(T6_FbReaction.defaultComment);
            break;

            case(R.id.fabPrevious):
                if(aux == 0){
                    aux = 4;
                    civ.setImageResource(images[aux]);

                } else {
                    aux--;
                    civ.setImageResource(images[aux]);
                }
            break;

            case(R.id.fabNext):

                if(aux == 4){
                    aux = 0;
                    civ.setImageResource(images[aux]);

                } else {
                    aux++;
                    civ.setImageResource(images[aux]);

                }
                break;
        }

    }
}
//Recaudar informacion de las reacciones
/*bReaccion.setOnReactionChangeListener(new ReactButton.OnReactionChangeListener() {
            @Override
            public void onReactionChange(Reaction reaction) {
            }
        });

        bReaccion.setOnReactionDialogStateListener(new ReactButton.OnReactionDialogStateListener() {
            @Override
            public void onDialogOpened() {
            }

            @Override
            public void onDialogDismiss() {
            }
        });*/