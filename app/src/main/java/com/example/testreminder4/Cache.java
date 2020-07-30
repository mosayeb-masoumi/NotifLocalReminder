package com.example.testreminder4;

import android.content.Context;
import android.content.SharedPreferences;

public class Cache {


    private static final String APP_SETTINGS = "UserNameAcrossApplication";

    private Cache() {}

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE);
    }

    // cache string
    public static String getString(Context context,String key) {
        return getSharedPreferences(context).getString(key , null);
    }
    public static void setString(Context context,String key,String newValue) {
        getSharedPreferences(context).edit().putString(key , newValue).apply();
    }

    // cache integer
    public static Integer getInt(Context context,String key) {
        return getSharedPreferences(context).getInt(key , 0);
    }
    public static void setInt(Context context,String key,Integer newValue) {
        getSharedPreferences(context).edit().putInt(key , newValue).apply();
    }


    // cache Long
    public static Long getLong(Context context,String key) {
        return getSharedPreferences(context).getLong(key , 0);
    }
    public static void setLong(Context context,String key,Long newValue) {
        getSharedPreferences(context).edit().putLong(key , newValue).apply();
    }

}
