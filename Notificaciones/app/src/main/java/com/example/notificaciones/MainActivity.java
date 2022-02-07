package com.example.notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;
    static final String CANAL_ID ="mi_canal";
    static final int NOTIFICACION_ID =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void onClick(View v) {
        //Creamos notificacion
        notificationManager = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        //Creamos el canal. SOLO puede hacerse en dispositivos con ver. 8 o más.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(
                    CANAL_ID, "Mis notificaciones",
                    NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("Descripción del canal");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder notificacion =
                new NotificationCompat.Builder(MainActivity.this,CANAL_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("Titulo de la notificación")
                        .setContentText("Este es el texto de la notificacion");
        notificationManager.notify(NOTIFICACION_ID, notificacion.build());
    }
    public void onDestroy()
    {
        super.onDestroy();
        notificationManager.cancel(NOTIFICACION_ID);
    }

}