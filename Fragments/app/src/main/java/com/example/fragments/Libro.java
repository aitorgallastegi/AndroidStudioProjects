package com.example.fragments;

public class Libro {

    private String titulo;
    private String autor;
    private String descripcion;
    private int hojas;

    public Libro(String titulo, String autor, String descripcion, int hojas) {
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.hojas = hojas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getHojas() {
        return hojas;
    }
}
