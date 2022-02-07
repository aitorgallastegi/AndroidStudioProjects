package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.txt);

        //Abrimos la base de datos "DBUsuarios" en modo de escritura
        UsuariosSQLiteHelper usdbh =
                new UsuariosSQLiteHelper(this, "DBUsuarios", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        //Si hemos abierto correctamente la base de datos
        if (db != null) {

            //Insertamoa 5 usuarios de ejemplo
            for (int i = 1; i <= 5; i++) {
                //Generamos los datos
                int codigo = i;
                String nombre = "Usuario " + i;
                String email = "usuario" + i + "@usuarios.com";
                //Insertamos los datos en la tabla de Usuarios
                db.execSQL("INSERT INTO Usuarios (idUsuario, nombre, email)" +
                        " VALUES (" + codigo + " ,'" + nombre + "','" + email + "')");
            }
            //Cerramos la base de datos


            String[] campos = new String[]{"idUsuario", "nombre", "email"};
            String[] args = new String[]{"Usuario 3"};
            Cursor c = db.query("Usuarios", campos, "nombre=?", args, null, null, null);
            //Recorremos los resultados para mostrarlos en pantalla
            txt.setText("");

            //Nos aseguramos de que existe al menos un registro
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros.
                do {
                    int codigo = c.getInt(0);
                    String nombre = c.getString(1);
                    String email = c.getString(2);
                    txt.append(codigo + " - " + nombre + " - " + email + "\n");
                } while (c.moveToNext());
            }
            db.close();
        }
    }
}