package com.app.programacion_multimedia.tema7;

import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app.programacion_multimedia.R;


public class Frag_t7_casos extends Fragment implements View.OnClickListener {

    private Spinner spinnerMusica;
    private String cancion;
    private int cancionID, flujodemusica;
    private MediaPlayer mp;
    private Button bComenzar;
    private Button bPausar;
    private SoundPool sp;
    private boolean loaded;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.t7_frag_casos, container, false);

        bComenzar = v.findViewById(R.id.bComenzar);
        Button bParar = v.findViewById(R.id.bParar);
        bPausar = v.findViewById(R.id.bPausar);

        spinnerMusica = v.findViewById(R.id.spinnerMusica);

        SeekBar seekBar = v.findViewById(R.id.seekBar);
        TextView seekBarHint = v.findViewById(R.id.seekBarHint);

        ImageView bTrompeta = v.findViewById(R.id.bTrompeta);
        ImageView bTambor = v.findViewById(R.id.bTambor);
        ImageView bCabra = v.findViewById(R.id.bCabra);
        ImageView bPajaro = v.findViewById(R.id.bPajaro);
        ImageView bSeta = v.findViewById(R.id.bSeta);
        ImageView bCoin = v.findViewById(R.id.bCoin);

        bComenzar.setOnClickListener(this);
        bParar.setOnClickListener(this);
        bPausar.setOnClickListener(this);

        bTrompeta.setOnClickListener(this);
        bTambor.setOnClickListener(this);
        bCabra.setOnClickListener(this);
        bPajaro.setOnClickListener(this);
        bSeta.setOnClickListener(this);
        bCoin.setOnClickListener(this);

        String[] valores = {"Seleccione", "Bach","Mozart","Beethoven"};
        mp = null;
        cancionID = 0;
        flujodemusica = 0;
        loaded = false;

        spinnerMusica.setAdapter(new ArrayAdapter<>(Frag_t7_casos.this.getContext(), R.layout.resource_item_spinner_main, valores));
        spinnerMusica.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                cancion = spinnerMusica.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.bComenzar):
                cambiarMusica();
                if(mp != null){
                    if(!mp.isPlaying()) {
                        mp.start();
                        bComenzar.setBackgroundColor(Color.GREEN);
                        bPausar.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));

                    }
                }
            break;

            case(R.id.bParar):
                if(mp != null) {
                    mp.stop();
                    bComenzar.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                    bPausar.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));

                }

            break;

            case (R.id.bPausar):
                if(mp != null)
                    if(mp.isPlaying()){
                        mp.pause();
                        bComenzar.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                        bPausar.setBackgroundColor(Color.YELLOW);

                    } else {
                        mp.start();
                        bComenzar.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
                        bPausar.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));

                    }

            break;

            case (R.id.bTrompeta):
                crearSonido(R.raw.s_trompeta);
                if(flujodemusica != 0)
                    sp.play(flujodemusica, 1, 1, 0, 0,1);
            break;

            case (R.id.bTambor):

            break;

            case (R.id.bCabra):

            break;

            case (R.id.bPajaro):

            break;

            case (R.id.bSeta):

            break;

            case (R.id.bCoin):

            break;
        }
    }

    public void cambiarMusica (){
        switch (cancion){
            case "Bach":
                cancionID = R.raw.mu_bach;
                break;

            case "Mozart":
                cancionID = R.raw.mu_mozart;
                break;

            case "Beethoven":
                cancionID = R.raw.mu_beethoven;
            break;

            default:
                cancionID = 0;
            break;
        }

        if(cancionID == 0){
            Toast.makeText(Frag_t7_casos.this.getContext(), "Elija una canción", Toast.LENGTH_SHORT).show();

        } else {
            mp = MediaPlayer.create(Frag_t7_casos.this.getContext(), cancionID);
        }
    }

    public void crearSonido(int sonidoID) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();
            sp = new SoundPool.Builder()
                    .setAudioAttributes(attributes)
                    .build();
        } else {
            sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }

        flujodemusica = sp.load(Frag_t7_casos.this.getContext(), sonidoID, 1);
        sp.setOnLoadCompleteListener((soundPool, sampleId, status) -> loaded = true);
    }
}