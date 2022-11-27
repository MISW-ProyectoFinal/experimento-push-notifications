package com.example.experimento_push_notifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.microsoft.windowsazure.messaging.notificationhubs.NotificationHub

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NotificationHub.setListener(CustomNotificationListener())
        NotificationHub.start(this.application, "experimentopushNotifications", "<ConnectionString>")
    }
}