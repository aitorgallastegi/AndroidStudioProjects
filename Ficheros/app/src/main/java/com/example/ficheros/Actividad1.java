package com.example.ficheros;

import static android.os.Environment.DIRECTORY_PODCASTS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Actividad1 extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7;
    private TextView txt1;
    private EditText edt1;
    private Boolean sdDisp,sdWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad1);


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);

        txt1 = (TextView) findViewById(R.id.txt1);
        edt1 = (EditText) findViewById(R.id.edt1);

        String estado = Environment.getExternalStorageState();
        if (estado.equals(Environment.MEDIA_MOUNTED)) {
            sdDisp = true;
            sdWrite = true;
        }
        else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            sdDisp = true;
            sdWrite = false;
        }
        else {
            sdDisp = false;
            sdWrite = false;
            btn2.setEnabled(false);
            btn4.setEnabled(false);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    OutputStreamWriter osw = new OutputStreamWriter(openFileOutput("prueba_int.txt", Context.MODE_PRIVATE));
                    osw.write(edt1.getText().toString());
                    osw.close();
                }
                catch (Exception e) {

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File ruta_sd = getApplicationContext().getExternalFilesDir(DIRECTORY_PODCASTS);
                    File f = new File (ruta_sd.getAbsolutePath(),"prueba_sd.txt");
                    OutputStreamWriter osw =
                            new OutputStreamWriter(new FileOutputStream(f));
                    osw.write(edt1.getText().toString());
                    osw.close();
                }
                catch (Exception ex) {
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("prueba_int.txt")));
                    String texto = fin.readLine();
                    fin.close();
                    txt1.setText(texto);

                }
                catch (Exception ex){
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File ruta_sd = getApplicationContext().getExternalFilesDir(DIRECTORY_PODCASTS);
                    File f = new File (ruta_sd.getAbsolutePath(),"prueba_sd.txt");

                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(new FileInputStream(f)));
                    String texto= br.readLine();
                    br.close();
                    txt1.setText(texto);

                }
                catch (Exception ex) {
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream fraw =
                            getResources().openRawResource(R.raw.prueba_raw);
                    BufferedReader brin =
                            new BufferedReader(new InputStreamReader(fraw));
                    String texto = "";
                    String linea = brin.readLine();
                    while (linea != null) {
                        texto = texto + linea + "\n";
                        linea = brin.readLine();
                    }
                    fraw.close();
                    txt1.setText(texto);
                } catch (Exception ex) {
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    File dir = getFilesDir();
                    File file = new File(dir, "prueba_int.txt");
                    file.delete();

                }
                catch (Exception ex){
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    File file = new File(getApplicationContext().getExternalFilesDir(DIRECTORY_PODCASTS).getAbsolutePath()+"/prueba_sd.txt");
                    file.delete();

                }
                catch (Exception ex){
                }
            }
        });


    }
}