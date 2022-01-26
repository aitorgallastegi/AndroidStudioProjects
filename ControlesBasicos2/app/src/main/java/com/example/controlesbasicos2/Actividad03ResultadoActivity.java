package com.example.controlesbasicos2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Actividad03ResultadoActivity extends AppCompatActivity {
    private TextView txtNombre,txtSexo,txtAficiones;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad03resultado);

        String deporte = "";
        String lectura = "";
        String musica = "";
        String viajar = "";


        txtNombre= (TextView) findViewById(R.id.txtNombre);
        txtSexo= (TextView) findViewById(R.id.txtSexo);
        txtAficiones= (TextView) findViewById(R.id.txtAficiones);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellido = extras.getString("apellido");
        Boolean chkDeporte = extras.getBoolean("chkDeporte");
        Boolean chkLectura = extras.getBoolean("chkLectura");
        Boolean chkMusica = extras.getBoolean("chkMusica");
        Boolean chkViajar = extras.getBoolean("chkViajar");
        String selectedtext = extras.getString("selectedtext");

        if (chkDeporte){
            deporte = "Deporte";
        }else{
            deporte = "";
        }
        if (chkLectura){
            lectura = "Lectura";
        }else{
            lectura = "";
        }
        if (chkMusica){
            musica = "Musica";
        }else{
            musica = "";
        }
        if (chkViajar){
            viajar = "Viajar";
        }else{
            viajar = "";
        }
        txtNombre.setText("Nombre: "+nombre+" "+apellido);
        txtSexo.setText("Sexo: "+selectedtext);
        txtAficiones.setText("Aficiones: "+deporte+lectura+musica+viajar);



    }
}
