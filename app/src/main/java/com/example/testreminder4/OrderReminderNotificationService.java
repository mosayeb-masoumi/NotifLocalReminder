package com.example.testreminder4;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class OrderReminderNotificationService extends IntentService {



    public OrderReminderNotificationService() {
        super("OrderReminderNotificationService");
    }
    /**
     * @param name
     * @deprecated
     */
    public OrderReminderNotificationService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);

        Context context = getApplicationContext();
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                context);

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        mBuilder.setContentTitle("Notification");
        mBuilder.setContentText("content");
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setSound(uri);
        mBuilder.setAutoCancel(true);

//        Intent notificationIntent = new Intent(this, LoginActivity.class);
//        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
//        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(2, mBuilder.build());

        stopSelf();
    }
}
