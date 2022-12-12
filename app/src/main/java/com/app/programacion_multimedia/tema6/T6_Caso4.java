package com.app.programacion_multimedia.tema6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.programacion_multimedia.R;

import java.util.Random;

public class T6_Caso4 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t6_caso4);

        Button bDefecto = findViewById(R.id.bDefecto);
        Button bAleatorioo = findViewById(R.id.bAleatorio);
        Button bPersonalizado = findViewById(R.id.bPersonalizado);

        bDefecto.setOnClickListener(this);
        bAleatorioo.setOnClickListener(this);
        bPersonalizado.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case (R.id.bDefecto):
                Toast.makeText(this, "Toast por defecto", Toast.LENGTH_SHORT).show();
            break;

            case(R.id.bAleatorio):
                Random r = new Random();
                Toast t2 = new Toast(this);
                View layout = getLayoutInflater().inflate(R.layout.t6_toast, findViewById(R.id.lytLayout));
                TextView tMessage = layout.findViewById(R.id.tMessage);
                tMessage.setText(R.string.custom_toas);
                t2.setDuration(Toast.LENGTH_SHORT);
                t2.setView(layout);
                switch (r.nextInt(4)) {

                    case 0:
                        t2.setGravity(Gravity.CENTER | Gravity.TOP, 0, 25);
                        tMessage.setText(R.string.up_toast);
                    break;

                    case 1:
                        t2.setGravity(Gravity.CENTER | Gravity.LEFT, 25, 0);
                        tMessage.setText(R.string.left_toast);
                    break;

                    case 2:
                        t2.setGravity(Gravity.CENTER | Gravity.RIGHT, 0, 0);
                        tMessage.setText(R.string.right_toast);
                    break;

                    case 3:
                        t2.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                        tMessage.setText(R.string.bottom_toast);
                    break;
                }
                t2.show();
            break;

            case(R.id.bPersonalizado):
                Toast t3 = new Toast(this);
                View layout2 = getLayoutInflater().inflate(R.layout.t6_toast, findViewById(R.id.lytLayout));
                TextView tMessage2 = layout2.findViewById(R.id.tMessage);
                tMessage2.setText(R.string.custom_toas);
                t3.setDuration(Toast.LENGTH_SHORT);
                t3.setView(layout2);
                t3.show();
            break;
        }
    }
}