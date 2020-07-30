package com.example.testreminder4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // make sure to disable battery saving for this app


    DatePicker datePicker;
    TimePicker timePicker;
    Button btn;
    EditText edt_title,edt_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = findViewById(R.id.datepicker);
        timePicker = findViewById(R.id.timepicker);
        edt_title = findViewById(R.id.edt_title);
        edt_content = findViewById(R.id.edt_content);
        timePicker.setIs24HourView(true);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int dpYear = datePicker.getYear();
                int dpMonth = datePicker.getMonth();
                int dpDay = datePicker.getDayOfMonth();

                int tpHour = timePicker.getCurrentHour();
                int tpMinute = timePicker.getCurrentMinute();

                String title = edt_title.getText().toString();
                String content = edt_content.getText().toString();

                SetNotification.setNotif(getApplicationContext(),dpYear,dpMonth,dpDay,tpHour,tpMinute,title,content);



                           //worked
                ////////***************************************************///////////////
//                Intent intent = new Intent(MainActivity.this, ReminderAlarmManager.class);
//                intent.putExtra("TITLE" ,edt_title.getText().toString());
//                intent.putExtra("CONTENT" ,edt_content.getText().toString());
//
//                int requestCode;
//                if(Cache.getInt(MainActivity.this,"REQUESTCODE") ==null ||
//                        Cache.getInt(MainActivity.this,"REQUESTCODE")==0){
//                    requestCode =0;
//                }else{
//                    requestCode = Cache.getInt(MainActivity.this,"REQUESTCODE");
//                }
//
//
//
//                Calendar alarmStartTime = Calendar.getInstance();
//                alarmStartTime.set(Calendar.YEAR,dpYear);
//                alarmStartTime.set(Calendar.MONTH,dpMonth);
//                alarmStartTime.set(Calendar.DAY_OF_MONTH, dpDay);
//                alarmStartTime.set(Calendar.HOUR_OF_DAY,tpHour );
//                alarmStartTime.set(Calendar.MINUTE, tpMinute);
//                alarmStartTime.set(Calendar.SECOND, 0);
//                                                                                                                   // flg must be 0
//                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),requestCode, intent, 0);
//                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//                alarmManager.set(AlarmManager.RTC, alarmStartTime.getTimeInMillis(), pendingIntent);
//
//                Cache.setInt(MainActivity.this,"REQUESTCODE", requestCode+1);
//
//                int f = requestCode;
//                int g = f;





            }
        });



               //  worked
///*******************************************************************//
//        Intent alarmIntent = new Intent(MainActivity.this, ReminderAlarmManager.class);
//
//        Calendar alarmStartTime = Calendar.getInstance();
//        Calendar now = Calendar.getInstance();
//
//        alarmStartTime.set(Calendar.DAY_OF_MONTH ,29);
//        alarmStartTime.set(Calendar.HOUR_OF_DAY, 13);
//        alarmStartTime.set(Calendar.MINUTE, 0);
//        alarmStartTime.set(Calendar.SECOND, 0);
//
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
////        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime.getTimeInMillis(), pendingIntent);
//        alarmManager.set(AlarmManager.RTC, alarmStartTime.getTimeInMillis(), pendingIntent);

    }
}