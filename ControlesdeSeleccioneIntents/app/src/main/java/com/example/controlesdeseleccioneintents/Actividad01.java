package com.example.controlesdeseleccioneintents;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.temporal.Temporal;

public class Actividad01 extends AppCompatActivity{
    private Spinner spinner;
    private TextView txtPais,txtSup,txtPob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad01);

        spinner = (Spinner) findViewById(R.id.spinner);
        txtPais = (TextView) findViewById(R.id.txtPais);
        txtSup = (TextView) findViewById(R.id.txtSup);
        txtPob = (TextView) findViewById(R.id.txtPob);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lista_paises, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
                parent.getItemAtPosition(pos).toString();
                txtPais.setText("Pais: "+parent.getItemAtPosition(pos).toString());
                if (pos==0){
                    txtPob.setText("Poblacion: 123456");
                    txtSup.setText("Superficie: 46583");
                }else if (pos==1){
                    txtPob.setText("Poblacion: 3456");
                    txtSup.setText("Superficie: 345622");
                }else if (pos==2){
                    txtPob.setText("Poblacion: 23435");
                    txtSup.setText("Superficie: 685765");
                }else if (pos==3){
                    txtPob.setText("Poblacion: 11111");
                    txtSup.setText("Superficie: 9876");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


    }


}