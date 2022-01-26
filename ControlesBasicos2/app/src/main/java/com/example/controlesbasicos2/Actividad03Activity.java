package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Actividad03Activity extends AppCompatActivity {
    private Button btnEnviar;
    private EditText edtNombre, edtApellidos;
    private RadioButton radioMasculino, radioFemenino;
    private RadioGroup group;
    private CheckBox checkMusica, checkLectura, checkDeporte, checkViajar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad03);

        btnEnviar = (Button) findViewById(R.id.btnEnviar);
        edtApellidos = (EditText) findViewById(R.id.edtApellidos);
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        radioMasculino = (RadioButton) findViewById(R.id.radioMasculino);
        radioFemenino = (RadioButton) findViewById(R.id.radioFemenino);
        checkDeporte = (CheckBox) findViewById(R.id.checkDeporte);
        checkLectura = (CheckBox) findViewById(R.id.checkLectura);
        checkMusica = (CheckBox) findViewById(R.id.checkMusica);
        checkViajar = (CheckBox) findViewById(R.id.checkViajar);
        group = (RadioGroup) findViewById(R.id.group);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String nombre = edtNombre.getText().toString();
                String apellido = edtApellidos.getText().toString();
                boolean chkDeporte = checkDeporte.isChecked();
                boolean chkLectura = checkLectura.isChecked();
                boolean chkMusica = checkMusica.isChecked();
                boolean chkViajar = checkViajar.isChecked();
                int radioButtonID = group.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) group.findViewById(radioButtonID);
                String selectedtext = (String) radioButton.getText();

                if (nombre.equals("") || apellido.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Introduce nombre y apellido por favor", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Intent intento = new Intent(Actividad03Activity.this, Actividad03ResultadoActivity.class);
                    intento.putExtra("nombre", nombre);
                    intento.putExtra("apellido", apellido);
                    intento.putExtra("chkDeporte", chkDeporte);
                    intento.putExtra("chkLectura", chkLectura);
                    intento.putExtra("chkMusica", chkMusica);
                    intento.putExtra("chkViajar", chkViajar);
                    intento.putExtra("selectedtext", selectedtext);
                    startActivity(intento);
                }
            }
        });


    }


}