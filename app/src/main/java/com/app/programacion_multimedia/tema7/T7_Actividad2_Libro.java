package com.app.programacion_multimedia.tema7;

public class T7_Actividad2_Libro {

    private String nombre, descripcion, ISBN;
    private int imagenID;

    public T7_Actividad2_Libro(String nombre, String descripcion, String ISBN, int imagenID) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ISBN = ISBN;
        this.imagenID = imagenID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public int getImagenID() {
        return imagenID;
    }

    public void setImagenID(int imagen) {
        this.imagenID = imagen;
    }
}
