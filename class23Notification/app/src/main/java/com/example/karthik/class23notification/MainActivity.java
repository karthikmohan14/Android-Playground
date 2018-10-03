package com.example.karthik.class23notification;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShow, btnClear;

    NotificationManager manager;

    Notification myNotication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button) findViewById(R.id.btnShowNotification);
        btnClear = (Button) findViewById(R.id.btnClearNotification);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        btnShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //API level 11
                Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                //Intent intent = new Intent();
                //PendingIntent.FLAG_UPDATE_CURRENT - Flag indicating that if the described PendingIntent already exists,
                // then keep it but replace its extra data with what is in this new Intent.
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 1,
                        intent, PendingIntent.FLAG_UPDATE_CURRENT);

                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setAutoCancel(true);
                builder.setTicker("this is ticker text");
                builder.setContentTitle("App Notification");
                builder.setContentText("You have a new message");
                builder.setSmallIcon(R.drawable.notifi_icon);
                builder.setContentIntent(pendingIntent);
                builder.setOngoing(true);
                builder.setSubText("This is subtext...");   //API level 16
                builder.setNumber(100);
                myNotication= builder.build();
                //  myNotication = builder.getNotification();
                // myNotication.flags = Notification.FLAG_AUTO_CANCEL;
                manager.notify(11,myNotication);

            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                manager.cancel(11);
            }
        });

    }

}
