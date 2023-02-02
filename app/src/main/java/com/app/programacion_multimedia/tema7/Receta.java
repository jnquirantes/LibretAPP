package com.app.programacion_multimedia.tema7;

import java.util.ArrayList;

public class Receta {

    private String titulo, preparacion, categoria;
    private ArrayList<String> ingredientes;

    public Receta(String titulo, String preparacion, ArrayList<String> ingredientes, String categoria) {
        this.titulo = titulo;
        this.preparacion = preparacion;
        this.ingredientes = ingredientes;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPreparacion() { return preparacion;}

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) {this.categoria = categoria;}
}
