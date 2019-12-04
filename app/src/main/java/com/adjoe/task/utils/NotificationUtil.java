package com.adjoe.task.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import com.adjoe.task.R;

public class NotificationUtil {

    public static void showNotification(Context context, String time) {

        Notification notification;
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            notification = new Notification.Builder(context)
                    .setContentTitle(time)
                    .setContentText("User Active Since")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .build();

        } else {

            notification = new Notification.Builder(context, "0")
                    .setContentTitle(time)
                    .setContentText("User Active Since")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .build();

        }

        mNotificationManager.notify(1, notification);
    }

}