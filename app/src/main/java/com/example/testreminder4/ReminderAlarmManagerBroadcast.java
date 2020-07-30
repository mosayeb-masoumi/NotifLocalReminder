package com.example.testreminder4;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class ReminderAlarmManagerBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


//            Intent i = new Intent(context, OrderReminderNotificationService.class);
//            context.startService(i);


        if(intent.getExtras()!=null){


            //Yes intent
//            Intent yesReceive = new Intent();
//            yesReceive.setAction("YES_ACTION");
//            PendingIntent pendingIntentYes = PendingIntent.getBroadcast(context, 12345, yesReceive, PendingIntent.FLAG_UPDATE_CURRENT);
////            mBuilder.addAction(R.drawable.ic_launcher_background, "Yes", pendingIntentYes);
//
////Maybe intent
//            Intent maybeReceive = new Intent();
//            maybeReceive.setAction("MAYBE_ACTION");
//            PendingIntent pendingIntentMaybe = PendingIntent.getBroadcast(context, 12345, maybeReceive, PendingIntent.FLAG_UPDATE_CURRENT);
////            mBuilder.addAction(R.drawable.ic_launcher_background, "Partly", pendingIntentMaybe);
//
////No intent
//            Intent noReceive = new Intent();
//            noReceive.setAction("NO_ACTION");
//            PendingIntent pendingIntentNo = PendingIntent.getBroadcast(context, 12345, noReceive, PendingIntent.FLAG_UPDATE_CURRENT);
////            mBuilder.addAction(R.drawable.ic_launcher_background, "No", pendingIntentNo);

//            String action  = intent.getAction();
//            if("YES_ACTION".equals(action)) {
//                Toast.makeText(context, "yes clicked", Toast.LENGTH_SHORT).show();
//            } else if("MAYBE_ACTION".equals(action)) {
//                Toast.makeText(context, "maybe clicked", Toast.LENGTH_SHORT).show();
//            } else if("NO_ACTION".equals(action)) {
//                Toast.makeText(context, "no clicked", Toast.LENGTH_SHORT).show();
//            }


            String title = intent.getExtras().getString("TITLE");
            String content = intent.getExtras().getString("CONTENT");

            String ns = Context.NOTIFICATION_SERVICE;
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(ns);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
                    context);

            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            mBuilder.setContentTitle(title);
            mBuilder.setContentText(content);
            mBuilder.setSmallIcon(R.mipmap.ic_launcher);
            mBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);

//            mBuilder.addAction(R.drawable.ic_launcher_background, "Yes", pendingIntentYes);
//            mBuilder.addAction(R.drawable.ic_launcher_background, "Partly", pendingIntentMaybe);
//            mBuilder.addAction(R.drawable.ic_launcher_background, "No", pendingIntentNo);


            mBuilder.setSound(uri);
            mBuilder.setAutoCancel(true);

            int notifId = (int) System.currentTimeMillis();
            mNotificationManager.notify(notifId, mBuilder.build());






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
