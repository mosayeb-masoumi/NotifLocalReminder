package com.example.testreminder4;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class ReminderAlarmManagerBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        /**
              // to start service
//            Intent i = new Intent(context, OrderReminderNotificationService.class);
//            context.startService(i);
        // remove al codes below **/


        if(intent.getExtras()!=null){

            int notifId = intent.getExtras().getInt("REQUEST_ID");

            // to start second activity
            Intent secondIntent = new Intent(context ,SecondActivity.class);
            secondIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent secondPendingIntent = PendingIntent.getActivity(context,0 ,secondIntent,PendingIntent.FLAG_ONE_SHOT);


            // to start web intent
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.shahrekhabar.com/"));
            webIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingWebIntent =
                    PendingIntent.getActivity(context, 0, webIntent, 0) ;


            // to cancelgit add button start CancelSevice or CancelBroadcast
            Intent cancelIntent = new Intent(context ,CancelBroadcast.class);
            cancelIntent.putExtra("NOTIF_ID", notifId);
//            cancelIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent cancelPendingIntent = PendingIntent.getBroadcast(context,notifId ,cancelIntent,PendingIntent.FLAG_ONE_SHOT);
            // to start service
//            PendingIntent cancelPendingIntent = PendingIntent.getService(context,0 ,cancelIntent,PendingIntent.FLAG_ONE_SHOT);




//            RemoteViews collapsedView = new RemoteViews(context.getPackageName(),R.layout.colaps_notif_view);
//            RemoteViews expandedView = new RemoteViews(context.getPackageName(),R.layout.expanded_notif_view);


            String title = intent.getExtras().getString("TITLE");
            String content = intent.getExtras().getString("CONTENT");

            String ns = Context.NOTIFICATION_SERVICE;
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(ns);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);


            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            mBuilder.setContentTitle(title);
            mBuilder.setContentText(content);


//            mBuilder.setCustomContentView(collapsedView);
//            mBuilder.setCustomBigContentView(expandedView);

            mBuilder.setSmallIcon(R.drawable.icon);
            mBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);


            // to start second Activity
            mBuilder.addAction(R.drawable.icon, "show", secondPendingIntent);
            mBuilder.addAction(0, "web", pendingWebIntent);
            mBuilder.addAction(0, "cancel", cancelPendingIntent);

            mBuilder.setSound(uri);

            // dismiss on tap
            mBuilder.setAutoCancel(true);


//            int notifId = (int) System.currentTimeMillis();
            mNotificationManager.notify(notifId, mBuilder.build());



//            mNotificationManager.cancel(notifId);


/************************** create unique id with shareprefrence****************

            // these below line is for update id to prevent overriding notifications (to show all notifications)
//            int idCode;
//            if(Cache.getInt(context,"IDCODE") ==null ||
//                    Cache.getInt(context,"IDCODE")==0){
//                idCode =0;
//            }else{
//                idCode = Cache.getInt(context,"IDCODE");
//            }
//
//            mNotificationManager.notify(idCode, mBuilder.build());
//            Cache.setInt(context,"IDCODE", idCode+1);   **********/


        }
    }
}
