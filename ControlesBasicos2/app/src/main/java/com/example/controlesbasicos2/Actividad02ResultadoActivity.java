package com.example.controlesbasicos2;


import static com.example.controlesbasicos2.Actividad02Activity.RESULTADO;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Actividad02ResultadoActivity extends AppCompatActivity {

    private Button btnVolver;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad02resultado);

        Bundle extras = getIntent().getExtras();
        int n1 = extras.getInt("n1");
        int n2 = extras.getInt("n2");

        btnVolver = (Button) findViewById(R.id.btnVolver);
        txtResultado = (TextView) findViewById(R.id.txtResultado);


        if (n1==n2){
           txtResultado.setText("El resultado es: CORRECTO");
        }else{
            txtResultado.setText("El resultado es: INCORRECTO");
        }

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n1==n2){
                    Intent intento = new Intent();
                    intento.putExtra(String.valueOf(RESULTADO),1);
                    setResult(RESULT_OK,intento);
                    finish();
                }else{
                    Intent intento = new Intent();
                    intento.putExtra(String.valueOf(RESULTADO),1);
                    setResult(RESULT_CANCELED,intento);
                    finish();
                }


            }
        });

    }
}
