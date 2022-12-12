package com.app.programacion_multimedia.tema8;

public class Pescado {

    private String nombre, size, tipo;
    private int precio;

    public Pescado(String nombre, String size, String tipo, int precio) {
        this.nombre = nombre;
        this.size = size;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
