package com.example.laboratorionotificacin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.stream.DoubleStream;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotification();

        Button buttonShowNotification = findViewById(R.id.btnNotificacion);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"CHANNEL1")
                .setSmallIcon(R.drawable.ic_baseline_warning_24)
                .setContentTitle("Hola")
                .setContentText("Esto es mi primera notificacion")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager=NotificationManagerCompat.from(this);

        buttonShowNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificationManager.notify(100, builder.build());


            }
        });



    }
    private void createNotification(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            CharSequence name= "studentChannel";
            String description ="Channel for students";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel =new NotificationChannel("CHANNEL1",name,importance);
            channel.setDescription(description);

            NotificationManager notificationManager=getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}