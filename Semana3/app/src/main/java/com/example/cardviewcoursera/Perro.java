package com.example.cardviewcoursera;

public class Perro {

    private String nombre;
    private int rango;
    private int foto;


    public Perro(String nombre, int rango, int foto) {
        this.nombre = nombre;
        this.rango = rango;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRango() {
        return rango;
    }

    public void setEmail(int rango) {
        this.rango = rango;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
