package com.app.programacion_multimedia.tema7;

public class T7_Actividad2_Libro {

    private String nombre, descripcion, ISBN;
    private int imagenID;

    public T7_Actividad2_Libro(String nombre, String descripcion, String ISBN) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ISBN = ISBN;
    }

    public T7_Actividad2_Libro(String nombre, String descripcion, String ISBN, int imagenID) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ISBN = ISBN;
        this.imagenID = imagenID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getISBN() {
        return ISBN;
    }
}
