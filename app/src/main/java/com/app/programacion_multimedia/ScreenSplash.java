package com.app.programacion_multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import java.util.Random;

public class ScreenSplash extends AppCompatActivity {

    //Campos de clase
    private ProgressBar progressBar;
    private int progress;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_splash);

        progressBar = findViewById(R.id.progressBar);
        handler = new Handler();
        progress = 0;

        new Thread(() -> {
            while (progress < 100) {
                int n = new Random().nextInt(4);
                progress += n;
                android.os.SystemClock.sleep(50);   //50 ms de delay

                handler.post(() -> {
                    progressBar.setProgress(progress); //Cambia la barra de progreso
                });
            }

            //Cuando progress = 100
            handler.post(() -> {
                ScreenSplash.this.startActivity(new Intent(ScreenSplash.this.getApplicationContext(), MainActivity.class));
                ScreenSplash.this.finish();
            });
        }).start();
    }
}