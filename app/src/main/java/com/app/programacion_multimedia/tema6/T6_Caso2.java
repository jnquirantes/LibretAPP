package com.app.programacion_multimedia.tema6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.app.programacion_multimedia.R;

import java.util.Random;

public class T6_Caso2 extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progress = 0;
    private Random r = new Random();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t6_caso2);

        progressBar = findViewById(R.id.progress);

        new Thread(() -> {

            while (progress < 100) {
                int n = r.nextInt(3);
                progress += n;
                android.os.SystemClock.sleep(50); //50 ms de delay

                handler.post(() -> progressBar.setProgress(progress));
            }

            //En caso de que sea progress=>100
            handler.post(() -> {
                //Ejecutara la accion al salir del while anterior
                startActivity(new Intent(getApplicationContext(), Tema6.class));
                finish();
            });
        }).start();
    }
}