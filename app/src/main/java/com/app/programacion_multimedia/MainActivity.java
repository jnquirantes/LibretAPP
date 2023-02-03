package com.app.programacion_multimedia;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.app.programacion_multimedia.tema10.Tema10;
import com.app.programacion_multimedia.tema11_12.Tema11_12_juego;
import com.app.programacion_multimedia.tema4.Tema4;
import com.app.programacion_multimedia.tema5.Tema5;
import com.app.programacion_multimedia.tema6.Tema6;
import com.app.programacion_multimedia.tema7.Tema7;
import com.app.programacion_multimedia.tema8.Tema8;
import com.app.programacion_multimedia.tema9.Tema9;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMain;
    String temas = "";
    private LottieAnimationView animation;
    private Button elegir;
    public static boolean tema4, tema5, tema6, tema7, tema8,  tema9, tema10, tema11_12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elegir = findViewById(R.id.Elegir);
        elegir.setVisibility(View.GONE);
        animation = findViewById(R.id.animation);

        spinnerMain = findViewById(R.id.spinner);
        String[] valores = {"Seleccione", "Tema 4","Tema 5","Tema 6","Tema 7", "Tema 8", "Tema 9", "Tema 10"};
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
              public void onNothingSelected(AdapterView<?> parent) { }
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

                case "Tema 9":
                    Intent intent9 = new Intent(MainActivity.this, Tema9.class);
                    tema9 = true;
                    startActivity(intent9);
                break;

                case "Tema 10":
                    Intent intent10 = new Intent(MainActivity.this, Tema10.class);
                    tema10 = true;
                    startActivity(intent10);
                break;
               case "Tema 11-12":
                   Intent intent11_12 = new Intent(MainActivity.this, Tema11_12_juego.class);
                   tema11_12 = true;
                   startActivity(intent11_12);
               break;
         }
       });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // un listener que al pulsar, cierre la aplicacion
        new AlertDialog.Builder(this)
                .setTitle("¿Realmente desea cerrar la aplicación?")
                .setCancelable(true)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, (dialog, which) -> {
                    android.os.Process.killProcess(android.os.Process.myPid()); //Su funcion es algo similar a lo que se llama cuando se presiona el botón "Forzar Detención" o "Administrar aplicaciones", lo cuál mata la aplicación
                    //finish(); Si solo quiere mandar la aplicación a segundo plano
                }).show();
        return super.onKeyDown(keyCode, event);
    }
}