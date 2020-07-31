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


            // to snooze start CancelSevice or CancelBroadcast
            Intent cancelIntent = new Intent(context ,CancelBroadcast.class);
            cancelIntent.putExtra("NOTIF_ID", notifId);
//            cancelIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent cancelPendingIntent = PendingIntent.getBroadcast(context,0 ,cancelIntent,PendingIntent.FLAG_ONE_SHOT);

            // to start service
//            PendingIntent cancelPendingIntent = PendingIntent.getService(context,0 ,cancelIntent,PendingIntent.FLAG_ONE_SHOT);


            /***********************************************************************/

//            // to set snooze   test1
//            Intent snoozeIntent = new Intent(context, ReminderAlarmManagerBroadcast.class);
//            intent.putExtra("TITLE" ,intent.getExtras().getString("TITLE"));
//            intent.putExtra("CONTENT" ,intent.getExtras().getString("CONTENT"));
//            intent.putExtra("SNOOZE" ,intent.getExtras().getString("SNOOZE"));
//            int requestCode = (int) System.currentTimeMillis();
//            Calendar alarmStartTime = Calendar.getInstance();
//            alarmStartTime.set(Calendar.SECOND, alarmStartTime.getTime().getSeconds());
//
//            PendingIntent snoozePendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(),requestCode, snoozeIntent, 0);
//            AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {  // this line is need if we use setExact
//                // use setExact instead of set to remove delay of showing notif
//                alarmManager.setExact(AlarmManager.RTC, alarmStartTime.getTimeInMillis()+10, snoozePendingIntent);
//            }


            /*********************************************************/
            // to set snooze   test2
//            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//            Intent snoozeIntent = new Intent(context, ReminderAlarmManagerBroadcast.class);
//            int requestCode = (int) System.currentTimeMillis();
//            PendingIntent pendingSnoozIntent = PendingIntent.getBroadcast(context, requestCode, snoozeIntent, 0);
//
//            Calendar alarmStartTime = Calendar.getInstance();
//            alarmStartTime.set(Calendar.SECOND, 20);
//            //Repeat every 24 hours
//            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), 20*1000, pendingSnoozIntent);

              /***********************************************************************/

//             to set snooze   test3
//
//            Intent snoozeIntent = new Intent(context ,SetNotification.class);
//
////            secondIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            PendingIntent snoozePendingIntent = PendingIntent.getActivity(context,0 ,snoozeIntent,PendingIntent.FLAG_UPDATE_CURRENT);

            /***********************************************************************/

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
