package com.adjoe.task.utils;


import android.text.format.DateUtils;
import android.util.Log;

public class StringUtility {

    private static final String TAG = "StringUtility";

    public static String formatTime(long time){
        String formattedTime = DateUtils.getRelativeTimeSpanString(time , System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS).toString();
        Log.i(TAG, "formattedTime : " + formattedTime);
        return formattedTime;
    }
}
