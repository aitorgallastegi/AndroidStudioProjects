package com.example.xml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public String url = "https://www.europapress.es/rss/rss.aspx";
    private TextView txtResultado;
    private List<Noticia> noticias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResultado = (TextView)findViewById(R.id.txtResultado);

    }

    //Con la propiedad onClick en los botones
    public void cargarXMLConSAX (View v){
        CargarXmlTask tarea = new CargarXmlTask();
        tarea.execute(url);
    }

    private class CargarXmlTask extends AsyncTask<String,Integer,Boolean> {
        protected Boolean doInBackground(String... params) {
            RssParserSAX saxparser = new RssParserSAX(params[0]);
            noticias = saxparser.parse();
            return true;
        }
        protected void onPostExecute(Boolean result) {
            //Tratamos la lista de noticias
            //Por ejemplo: escribimos los títulos en pantalla
            txtResultado.setText("");
            if (noticias != null) {
                for (int i = 0; i < noticias.size(); i++) {
                    txtResultado.setText(
                            txtResultado.getText().toString() +
                                    System.getProperty("line.separator") +
                                    noticias.get(i).getTitulo());
                }
            }
        }
    }
}