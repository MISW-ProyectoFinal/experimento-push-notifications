package com.example.experimento_push_notifications;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.messaging.RemoteMessage.Notification;
import com.microsoft.windowsazure.messaging.notificationhubs.NotificationListener;

import java.util.Map;

public class CustomNotificationListener implements NotificationListener {
    private final String TAG = "Notifications";
    @Override
    public void onPushNotificationReceived(Context context, RemoteMessage message) {

        /* The following notification properties are available. */
        Notification notification = message.getNotification();
        String title = notification.getTitle();
        String body = notification.getBody();
        Map<String, String> data = message.getData();

        if (message != null) {
            Log.d(TAG, "Message Notification Title: " + title);
            Log.d(TAG, "Message Notification Body: " + body);
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context.getApplicationContext(), title, Toast.LENGTH_LONG).show();
                    Toast.makeText(context.getApplicationContext(), body, Toast.LENGTH_LONG).show();
                }
            });
        }

        if (data != null) {
            for (Map.Entry<String, String> entry : data.entrySet()) {
                Log.d(TAG, "key: " + entry.getKey() + " value: " + entry.getValue());
            }
        }
    }
}