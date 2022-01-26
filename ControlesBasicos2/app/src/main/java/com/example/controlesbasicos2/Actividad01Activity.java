package com.example.controlesbasicos2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Actividad01Activity extends AppCompatActivity{

    private TextView txtCondiciones;
    private Button btnValidar,btnAtras;
    private EditText edtNombre,edtApellido;
    private static final int REQUEST_CODE = 1234;
    public static final String CONDICION = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad01);

        btnValidar = (Button) findViewById(R.id.btnValidar);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtApellido = (EditText) findViewById(R.id.edtApellido);
        txtCondiciones = (TextView) findViewById(R.id.txtCondiciones);
        btnAtras = (Button) findViewById(R.id.btnAtras);



        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombre.getText().toString();
                String apellido = edtApellido.getText().toString();

                Intent intento = new Intent(Actividad01Activity.this,Actividad01CondicionesActivity.class);
                intento.putExtra("nombre",nombre);
                intento.putExtra("apellido",apellido);
                startActivityForResult(intento,REQUEST_CODE);
            }
        });
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Actividad01Activity.this,MainActivity.class);
                startActivity(intento);
            }
        });


    }
    @Deprecated
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 1234)&& (resultCode == RESULT_OK)){
            txtCondiciones.setText("Aceptas Condiciones: "+data.getStringExtra(CONDICION));
        }

    }

}
