package com.shreeshail.jobschedular.Services;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.shreeshail.jobschedular.R;
import com.shreeshail.jobschedular.Views.ForegroundServiceActivity;

import static com.shreeshail.jobschedular.Views.ForegroundServiceActivity.Channel_ID;

/**
 * Created by shreeshail on 16/7/19.
 */

public class ForegroundService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String input = intent.getStringExtra("input");

        Intent notificationintent = new Intent(this, ForegroundServiceActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0
                ,notificationintent,0);


        Notification notification = new NotificationCompat.Builder(this,Channel_ID)
                .setContentTitle("ForeGround Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_notifications_none_black_24dp)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1,notification);

        //stopSelf();

        return START_NOT_STICKY;

        /*If the system kills the service after onStartCommand() returns,
        do not recreate the service unless there are pending intents to deliver.
        This is the safest option to avoid running your service when not necessary
        and when your application can simply restart any unfinished jobs.*/

        /*
        START_STICKY
            If the system kills the service after onStartCommand() returns,
            recreate the service and call onStartCommand(), but do not redeliver
            the last intent. Instead, the system calls onStartCommand()
            with a null intent unless there are pending intents to start the service.
            In that case, those intents are delivered. This is suitable for media players
            (or similar services) that are not executing commands but are running indefinitely
            and waiting for a job.*/

        /*
        START_REDELIVER_INTENT
          If the system kills the service after onStartCommand() returns,
          recreate the service and call onStartCommand() with the last intent
          that was delivered to the service. Any pending intents are delivered in turn.
          This is suitable for services that are actively performing a job that should be
          immediately resumed, such as downloading a file.*/

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
