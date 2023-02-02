package com.app.programacion_multimedia.tema8.vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.programacion_multimedia.R;
import com.app.programacion_multimedia.adapter.T8_RecyclerID;
import com.app.programacion_multimedia.tema8.controlador.ControladorUser;
import com.app.programacion_multimedia.tema8.modelo.User;

import java.util.ArrayList;

public class T8_Actividad1 extends AppCompatActivity implements View.OnClickListener {

    private Button bBD, bBuscarID, bCrear;
    private boolean conectado = false;
    private EditText etID, etUser, etPass;
    private RecyclerView recycler;
    private ArrayList<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t8_actividad1);

        StrictMode.enableDefaults();

        etID = findViewById(R.id.etID);
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        bBD = findViewById(R.id.iBD);
        bBD.setOnClickListener(this);
        bBuscarID = findViewById(R.id.bBuscarID);
        bBuscarID.setOnClickListener(this);
        bCrear = findViewById(R.id.bCrear);
        bCrear.setOnClickListener(this);
        recycler = findViewById(R.id.recicyclerID);
        users = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            //NO RECIBE CONEXION
            case (R.id.iBD):
                if(!conectado) {
                    bBD.setBackgroundColor(Color.GREEN);
                    Toast.makeText(this, "Conectado a la Base de Datos", Toast.LENGTH_SHORT).show();
                    conectado = true;

                } else {
                    bBD.setBackgroundColor(Color.RED);
                    Toast.makeText(this, "Desconectado de la Base de Datos", Toast.LENGTH_SHORT).show();
                    conectado = false;
                }
                break;

            case (R.id.bBuscarID):
                if(conectado) {
                    recycler.setVisibility(View.VISIBLE);
                    ControladorUser.obtenerUsers(this, users, etID);
                    ArrayList<User> aux = new ArrayList<>(users);
                    recycler.setHasFixedSize(true);
                    LinearLayoutManager llm = new LinearLayoutManager(this);
                    recycler.setLayoutManager(llm);
                    T8_RecyclerID adaptador = new T8_RecyclerID(this, aux);
                    recycler.setAdapter(adaptador);
                    adaptador.refrescar();
                    etID.setText("");
                    users.clear();

                } else {
                    Toast.makeText(this, "Conectese a la Base de Datos", Toast.LENGTH_SHORT).show();
                }
            break;

            case (R.id.bCrear):
                ControladorUser.crearRegistro(this, etUser, etPass);
            break;
        }
    }
}