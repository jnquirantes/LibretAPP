package com.app.programacion_multimedia.tema4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.app.programacion_multimedia.R;

public class T4_Actividad1 extends AppCompatActivity {

    private String base;
    private int numero;
    private EditText etBase;
    private TextView tBinario, tOctal, tDecimal, tHexa;
    private RadioButton rBinario, rOctal, rDecimal, rHexa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t4_actividad1);

        rBinario = findViewById(R.id.rBinario);
        rOctal = findViewById(R.id.rOctal);
        rDecimal = findViewById(R.id.rDecimal);
        rHexa = findViewById(R.id.rHexa);

        etBase = findViewById(R.id.etBase);

        tBinario = findViewById(R.id.tBinario);
        tDecimal = findViewById(R.id.tDecimal);
        tOctal = findViewById(R.id.tOctal);
        tHexa = findViewById(R.id.tHexa);

        findViewById(R.id.bConvertir).setOnClickListener(v -> {
            base = etBase.getText().toString().trim();

            if(base.equals("")) {
                Toast.makeText(T4_Actividad1.this, "Introduce un numero", Toast.LENGTH_SHORT).show();

            } else {

                if(rBinario.isChecked()) {
                    getBase();
                    tBinario.setText(base);
                    tOctal.setText(binarioOctal());
                    tDecimal.setText(binarioDecimal());
                    tHexa.setText(binarioHexa());

                } else if(rOctal.isChecked()) {
                    getBase();
                    tBinario.setText(octalBinario());
                    tOctal.setText(base);
                    tDecimal.setText(octalDecimal());
                    tHexa.setText(octalHexa());


                } else if(rDecimal.isChecked()) {
                    getBase();
                    tBinario.setText(decimalBinario());
                    tOctal.setText(decimalOctal());
                    tDecimal.setText(base);
                    tHexa.setText(decimalHexa());

                } else if(rHexa.isChecked() && !base.equals("")){
                    tBinario.setText(hexaBinario());
                    tOctal.setText(hexaOctal());
                    tDecimal.setText(hexaDecimal());
                    tHexa.setText(base);
                }
            }
        });
    }

    public int getBase() {
        try {
            numero = Integer.parseInt(base);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número incorrecto", Toast.LENGTH_SHORT).show();
        }

        return numero;
    }

    public String binarioDecimal() {
        int binario = Integer.parseInt(base, 2);

        return String.valueOf(binario);
    }

    public String binarioOctal() {
        int num = Integer.parseInt(binarioDecimal());

        return Integer.toOctalString(num);
    }

    public String binarioHexa() {
        int num = Integer.parseInt(binarioDecimal());

        return Integer.toHexString(num);
    }

    public String octalBinario(){
        int num = Integer.parseInt(octalDecimal());

        return Integer.toBinaryString(num);
    }

    public String octalDecimal() {
        int octal = Integer.parseInt(base, 8);

        return String.valueOf(octal);
    }

    public String octalHexa() {
        int num = Integer.parseInt(octalDecimal());

        return Integer.toHexString(num);
    }

    public String decimalBinario() {

        return Integer.toBinaryString(numero);
    }

    public String decimalOctal() {

        return Integer.toOctalString(numero);
    }

    public String decimalHexa() {

        return Integer.toHexString(numero);
    }

    public String hexaBinario() {
        int num = Integer.parseInt(hexaDecimal());

        return Integer.toBinaryString(num);
    }

    public String hexaOctal(){
        int num = Integer.parseInt(hexaDecimal());

        return Integer.toOctalString(num);
    }

    public String hexaDecimal() {
        int num = Integer.parseInt(base, 16);

        return String.valueOf(num);
    }
}