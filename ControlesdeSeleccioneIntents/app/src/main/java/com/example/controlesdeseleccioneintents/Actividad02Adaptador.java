package com.example.controlesdeseleccioneintents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Actividad02Adaptador  extends ArrayAdapter<Actividad02PaginaWeb> {

    

    public Actividad02Adaptador(@NonNull Context context, Actividad02PaginaWeb[] datos) {
        super(context, R.layout.actividad02listview, datos);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.actividad02listview, null);

        TextView txtTitulo = (TextView)item.findViewById(R.id.txtTitulo);
        txtTitulo.setText(datosPagina[position].getTitulo());

        TextView txtSubtitulo = (TextView)item.findViewById(R.id.txtSubtitulo);
        txtSubtitulo.setText(datosPagina[position].getSubtitulo());

        ImageView img = (ImageView) item.findViewById(R.id.img);
        img.setImageResource(datosPagina[position].getImagen());

        return (item);
    }
}


