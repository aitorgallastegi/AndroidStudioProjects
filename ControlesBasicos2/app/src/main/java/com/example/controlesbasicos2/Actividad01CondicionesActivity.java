package com.example.controlesbasicos2;

import static com.example.controlesbasicos2.Actividad01Activity.CONDICION;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Actividad01CondicionesActivity extends AppCompatActivity {

    private TextView txt;
    private Button btnAceptar,btnRechazar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad01condiciones);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellido = extras.getString("apellido");

        txt = (TextView) findViewById(R.id.textView5);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnRechazar = (Button) findViewById(R.id.btnRechazar);

        txt.setText("Hola "+nombre+" "+apellido+" aceptas las condiciones?");

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent();
                intento.putExtra(CONDICION,"ACEPTADO");
                setResult(RESULT_OK,intento);
                finish();

            }
        });
        btnRechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent();
                intento.putExtra(CONDICION,"RECHAZADO");
                setResult(RESULT_OK,intento);
                finish();

            }
        });




    }
}
