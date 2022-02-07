package com.example.controlesdeseleccioneintents;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Actividad02 extends AppCompatActivity {


    private ListView list_view;
    private ImageView img;
    private TextView txtTitulo, txtSubtitulo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad02);

        list_view = (ListView) findViewById(R.id.list_view);
        img = (ImageView) findViewById(R.id.img);
        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        txtSubtitulo = (TextView) findViewById(R.id.txtSubtitulo);


        Actividad02PaginaWeb[] listaWebs =
                {
                        new Actividad02PaginaWeb("Steam", "Steam los mejores juegos", R.drawable.steam, "https://steam.com/"),
                        new Actividad02PaginaWeb("Youtube", "Youtube memes pasaos", R.drawable.steam, "https://youtube.com/"),
                        new Actividad02PaginaWeb("Reddit", "Reddit pa aburridos", R.drawable.steam, "https://www.reddit.com/"),
                };
        AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(this, listaWebs);
        list_view.setAdapter(adaptadorTitulares);


        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Actividad02PaginaWeb webSeleccionada = (Actividad02PaginaWeb) parent.getItemAtPosition(position);
                String urlWeb = webSeleccionada.getUrl();

                Uri uri = Uri.parse(urlWeb);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
    private class AdaptadorTitulares extends ArrayAdapter<Actividad02PaginaWeb>
    {
        private Actividad02PaginaWeb[] listaWebs;

        public AdaptadorTitulares(Context context, Actividad02PaginaWeb[] listaWebs)
        {
            super(context, R.layout.actividad02listview, listaWebs);
            this.listaWebs = listaWebs;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.actividad02listview, null);

            txtTitulo.setText(listaWebs[position].toString());

            txtSubtitulo.setText(listaWebs[position].getSubtitulo());



            return item;
        }
    }



}