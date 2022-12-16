package com.app.programacion_multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.app.programacion_multimedia.tema4.Tema4;
import com.app.programacion_multimedia.tema5.Tema5;
import com.app.programacion_multimedia.tema6.Tema6;
import com.app.programacion_multimedia.tema7.Tema7;
import com.app.programacion_multimedia.tema8.Tema8;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMain;
    String temas = "";
    private LottieAnimationView animation;
    private Button elegir;
    public static boolean tema4, tema5, tema6, tema7, tema8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elegir = findViewById(R.id.Elegir);
        elegir.setVisibility(View.GONE);
        animation = findViewById(R.id.animation);

        spinnerMain = findViewById(R.id.spinner);
        String[] valores = {"Seleccione", "Tema 4","Tema 5","Tema 6","Tema 7", "Tema 8"};
        spinnerMain.setAdapter(new ArrayAdapter<>(this, R.layout.resource_item_spinner_main, valores));
        spinnerMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                    temas = spinnerMain.getSelectedItem().toString();
                    animation.setVisibility(View.VISIBLE);
                  if(temas.equals("Seleccione")) {
                      Toast.makeText(MainActivity.this, "Bienvenid@", Toast.LENGTH_SHORT).show();
                  } else {
                      elegir.setVisibility(View.VISIBLE);
                  }
              }

              @Override
              public void onNothingSelected(AdapterView<?> parent) {

              }
        });

       findViewById(R.id.Elegir).setOnClickListener(v -> {

           switch(temas) {
             case "Tema 4":
                 Intent intent4 = new Intent(MainActivity.this, Tema4.class);
                 tema4 = true;
                 startActivity(intent4);
             break;

             case "Tema 5":
                 Intent intent5 = new Intent(MainActivity.this, Tema5.class);
                 tema5 = true;
                 startActivity(intent5);
             break;

             case "Tema 6":
                 Intent intent6 = new Intent(MainActivity.this, Tema6.class);
                 tema6 = true;
                 startActivity(intent6);
             break;

             case "Tema 7":
                 Intent intent7 = new Intent(MainActivity.this, Tema7.class);
                 tema7 = true;
                 startActivity(intent7);
             break;

             case "Tema 8":
                 Intent intent8 = new Intent(MainActivity.this, Tema8.class);

                 tema8 = true;
                 startActivity(intent8);
                 break;
         }

       });
    }
}