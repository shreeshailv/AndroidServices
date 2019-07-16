package com.shreeshail.jobschedular.Views;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.shreeshail.jobschedular.R;
import com.shreeshail.jobschedular.Services.ForegroundService;

public class ForegroundServiceActivity extends AppCompatActivity {
    public static final String TAG = "ForegroundServiceActivity";
    public static final String Channel_ID = "ForegroundServiceActivity";
    private EditText messagetext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreground_service);

        messagetext = findViewById(R.id.messagetext);

        createnotificationchannel();
    }

    public void createnotificationchannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(
                    Channel_ID,
                    "Example Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void startservice(View view){

        String message = messagetext.getText().toString();

        if (message.length()>0){
            Intent serviceintent = new Intent(getBaseContext(), ForegroundService.class);
            serviceintent.putExtra("input",message);
            ContextCompat.startForegroundService(this,serviceintent);
           //startService(serviceintent);
        }
    }
    public void stopservice(View view){
        Intent serviceintent = new Intent(getBaseContext(), ForegroundService.class);
        stopService(serviceintent);
    }
}
