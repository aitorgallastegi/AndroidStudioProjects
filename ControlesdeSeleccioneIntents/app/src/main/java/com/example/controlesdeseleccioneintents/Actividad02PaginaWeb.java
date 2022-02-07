package com.example.controlesdeseleccioneintents;

import android.widget.ImageView;

public class Actividad02PaginaWeb {

    private String titulo;
    private String subtitulo;
    private int imagen;
    private String url;

    public Actividad02PaginaWeb(String titulo, String subtitulo, int imagen,String url){
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.imagen = imagen;
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

