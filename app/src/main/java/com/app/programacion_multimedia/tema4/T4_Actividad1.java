package com.app.programacion_multimedia.tema4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        findViewById(R.id.bConvertir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        String decimal = String.valueOf(binario);

        return decimal;
    }

    public String binarioOctal() {
        int num = Integer.parseInt(binarioDecimal());
        String octal = Integer.toOctalString(num);

        return octal;
    }

    public String binarioHexa() {
        int num = Integer.parseInt(binarioDecimal());
        String hexa = Integer.toHexString(num);

        return hexa;
    }

    public String octalBinario(){
        int num = Integer.parseInt(octalDecimal());
        String binario = Integer.toBinaryString(num);

        return binario;
    }

    public String octalDecimal() {
        int octal = Integer.parseInt(base, 8);
        String decimal = String.valueOf(octal);

        return decimal;
    }

    public String octalHexa() {
        int num = Integer.parseInt(octalDecimal());
        String hexa = Integer.toHexString(num);

        return hexa;
    }

    public String decimalBinario() {
        String binario = Integer.toBinaryString(numero);

        return binario;
    }

    public String decimalOctal() {
        String octal = Integer.toOctalString(numero);

        return octal;
    }

    public String decimalHexa() {
        String hexa = Integer.toHexString(numero);

        return hexa;
    }

    public String hexaBinario() {
        int num = Integer.parseInt(hexaDecimal());
        String binario = Integer.toBinaryString(num);

        return binario;
    }

    public String hexaOctal(){
        int num = Integer.parseInt(hexaDecimal());
        String octal = Integer.toOctalString(num);

        return octal;
    }

    public String hexaDecimal() {
        int num = Integer.parseInt(base, 16);
        String decimal = String.valueOf(num);

        return decimal;
    }


    public boolean terminada(){
        return true;
    }
}