package com.app.programacion_multimedia.tema7;

import java.util.ArrayList;

public class T7_Actividad1_Receta {

    private String titulo;
    private String preparacion;
    private ArrayList<String> ingredientes;

    public T7_Actividad1_Receta(String titulo, String preparacion, ArrayList<String> ingredientes) {
        this.titulo = titulo;
        this.preparacion = preparacion;
        this.ingredientes = ingredientes;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPreparacion() {return preparacion;}

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }
}
