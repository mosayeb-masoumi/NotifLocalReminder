package com.example.testreminder4;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.Objects;

public class CancelService extends IntentService {



    public CancelService() {
        super("");

    }

    /**
     * @param name
     * @deprecated
     */
    public CancelService(String name) {
        super(name);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        int notif_id = intent.getExtras().getInt("NOTIF_ID2");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager mNotificationManager = (NotificationManager) getApplicationContext().getSystemService(ns);
        mNotificationManager.cancel(notif_id);
    }
}
