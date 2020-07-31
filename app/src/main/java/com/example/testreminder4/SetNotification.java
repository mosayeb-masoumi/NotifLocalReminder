package com.example.testreminder4;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

public class SetNotification {



    // make sure to disable battery saving for this app

    public static void setNotif(Context context ,int dpYear, int dpMonth, int dpDay, int tpHour, int tpMinute, String title, String content){

        int requestCode = (int) System.currentTimeMillis();

        Intent intent = new Intent(context, ReminderAlarmManagerBroadcast.class);
        intent.putExtra("TITLE" ,title);
        intent.putExtra("CONTENT" ,content);
        intent.putExtra("REQUEST_ID" ,requestCode);

        /**** create unique request code with shareprefrence
//        int requestCode;
//        if(Cache.getInt(context,"REQUESTCODE") ==null ||
//                Cache.getInt(context,"REQUESTCODE")==0){
//            requestCode =0;
//        }else{
//            requestCode = Cache.getInt(context,"REQUESTCODE");
//        }  ***/


//        int requestCode = (int) System.currentTimeMillis();


        Calendar alarmStartTime = Calendar.getInstance();
        alarmStartTime.set(Calendar.YEAR,dpYear);
        alarmStartTime.set(Calendar.MONTH,dpMonth);
        alarmStartTime.set(Calendar.DAY_OF_MONTH, dpDay);
        alarmStartTime.set(Calendar.HOUR_OF_DAY,tpHour );
        alarmStartTime.set(Calendar.MINUTE, tpMinute);
        alarmStartTime.set(Calendar.SECOND, 0);


                                                                                                          // flg must be 0 to show all registred notif
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(),requestCode, intent, 0);


        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {  // this line is need if we use setExact
                      // use setExact instead of set to remove delay of showing notif
            alarmManager.setExact(AlarmManager.RTC, alarmStartTime.getTimeInMillis(), pendingIntent);
        }


        /**** create unique request code with shareprefrence
//        Cache.setInt(context,"REQUESTCODE", requestCode+1);   ****/

    }

}
