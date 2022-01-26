package com.example.controlesbasicos2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Actividad02Activity extends AppCompatActivity{
    private EditText num1,num2,num3;
    private Button btn;
    private TextView txtCorrectas,txtIncorrectas;
    final int min = 1;
    final int max = 99;
    private static final int REQUEST_CODE = 1234;
    public static final int RESULTADO = 0;
    private int correcto,incorrecto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad02);

        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        num3 = (EditText) findViewById(R.id.num3);
        btn = (Button) findViewById(R.id.btn);
        txtCorrectas = (TextView) findViewById(R.id.txtCorrectas);
        txtIncorrectas = (TextView) findViewById(R.id.txtIncorrectas);

        final int random1 = new Random().nextInt((max - min) + 1) + min;
        final int random2 = new Random().nextInt((max - min) + 1) + min;

        num1.setText(String.valueOf(random1));
        num2.setText(String.valueOf(random2));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = random1+random2;
                int n2 = Integer.parseInt(num3.getText().toString());

                Intent intento = new Intent(Actividad02Activity.this,Actividad02ResultadoActivity.class);
                intento.putExtra("n1",n1);
                intento.putExtra("n2",n2);
                startActivityForResult(intento,REQUEST_CODE);
            }
        });





}}
