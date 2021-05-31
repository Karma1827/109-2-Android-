package com.example.android.a108590002_hw12_083;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private static final int JOB = 0;
    NotificationManager mNotifyManager;
    private static final String PRIMARY_CHANNEL= "primary_notification_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL, getResources().getString(R.string.channel_name), NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor( Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription(getResources().getString(R.string.channel_desc));
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    void sendNotification(){
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL)
                .setContentTitle(getResources().getString(R.string.title))
                .setContentText(getResources().getString(R.string.text))
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_download)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);
        mNotifyManager.notify(0, builder.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void Download(View view) {
        sendNotification();
        JobScheduler mScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName componentName = new ComponentName(getApplicationContext(), DownloadService.class.getName());
        JobInfo.Builder builder = new JobInfo.Builder(JOB, componentName);
        builder.setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setRequiresDeviceIdle(true)
                .setPeriodic( TimeUnit.DAYS.toMillis(1));
        if (Build.VERSION.SDK_INT > 23) {
            builder.setPeriodic(TimeUnit.DAYS.toMillis(1), TimeUnit.MINUTES.toMillis(5));
        }
        JobInfo jobInfo = builder.build();
        if (mScheduler != null) {
            mScheduler.schedule(jobInfo);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public class DownloadService extends JobService {
        @Override
        public boolean onStartJob(JobParameters params) {
            sendNotification();
            return false;
        }

        @Override
        public boolean onStopJob(JobParameters params) {
            return true;
        }
    }
}