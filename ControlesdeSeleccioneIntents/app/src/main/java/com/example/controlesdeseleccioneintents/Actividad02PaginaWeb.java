package com.example.controlesdeseleccioneintents;

import android.widget.ImageView;

public class Actividad02PaginaWeb {

    private String titulo;
    private String subtitulo;
    private int imagen;

    public Actividad02PaginaWeb(String tit, String sub, int img){
        titulo = tit;
        subtitulo = sub;
        imagen = img;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getSubtitulo(){
        return subtitulo;
    }
    public int getImagen(){
        return imagen;
    }
}

