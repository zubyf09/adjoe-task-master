package com.adjoe.task.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.adjoe.task.utils.Constants;

import static android.content.Context.MODE_PRIVATE;

public class UserPresentReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
            Log.i("TICK", intent.getAction());

            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SHARED_PREFERENCES, MODE_PRIVATE);
            sharedPreferences.edit().putLong(Constants.PHONE_UNLOCK_TIME, System.currentTimeMillis()).commit();

        }
    }

}