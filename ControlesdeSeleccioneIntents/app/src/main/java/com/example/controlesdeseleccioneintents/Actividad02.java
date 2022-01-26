package com.example.controlesdeseleccioneintents;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.ListView;


public class Actividad02 extends AppCompatActivity {

    private ListView list_view;
    private Actividad02PaginaWeb[] datosPagina = new Actividad02PaginaWeb[]{
            new Actividad02PaginaWeb("Titulo 1", "Subtitulo 1", R.drawable.steam),
            new Actividad02PaginaWeb("Titulo 2", "Subtitulo 2", R.drawable.steam)};


    Actividad02Adaptador adaptadorTitulares = new Actividad02Adaptador(this, datosPagina);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad02);


        list_view = (ListView)findViewById(R.id.list_view);
        list_view.setAdapter(adaptadorTitulares);


    }


}