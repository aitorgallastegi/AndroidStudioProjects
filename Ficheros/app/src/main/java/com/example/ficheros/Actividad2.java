package com.example.ficheros;

import static android.os.Environment.DIRECTORY_PODCASTS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Actividad2 extends AppCompatActivity {

    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);

        spinner = (Spinner) findViewById(R.id.spinner);

        try
        {
            ArrayList<String> datos = new ArrayList<String>();

            InputStream is = getResources().openRawResource(R.raw.provincias);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            int contProvincia = -1;
            String linea = br.readLine();
            while (linea != null)
            {
                datos.add(++contProvincia + ".- " + linea);
                linea = br.readLine();
            }
            br.close();

            //Creamos el adaptador para el spinner
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, datos);
            adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adaptador);
        }
        catch(Exception e)
        {
            Toast.makeText(this,"No se ha podido cargar la lista de provincias",Toast.LENGTH_LONG ).show();
        }





    }
}