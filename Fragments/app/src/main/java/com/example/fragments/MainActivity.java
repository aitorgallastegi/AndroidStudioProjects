package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity implements LibroListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListado fragmentListado =(FragmentListado)getSupportFragmentManager().
                        findFragmentById(R.id.frgListado);
        assert fragmentListado != null;
        fragmentListado.setLibroListener(this);
    }
    @Override
    public void onLibroSeleccionado(Libro c) {
        boolean hayDetalle =
                (getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!= null);
        if (hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager().
                    findFragmentById(R.id.frgDetalle)).mostrarDetalle(c.getDescripcion());
        }
        else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, c.getDescripcion());
            startActivity(i);
        }
    }
}
