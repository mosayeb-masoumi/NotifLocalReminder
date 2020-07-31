package com.example.testreminder4;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;

public class CancelBroadcast extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getExtras()!=null){

            int notif_id = intent.getExtras().getInt("NOTIF_ID");

            String ns = Context.NOTIFICATION_SERVICE;
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(ns);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);

            mNotificationManager.cancel(notif_id);
        }else{
            int a  = 5;
        }



    }


}
