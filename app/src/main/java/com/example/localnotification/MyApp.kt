package com.example.localnotification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.example.localnotification.NotificationService.Companion.Notification_Channel_ID

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                Notification_Channel_ID,
                "Celebrations reminder",
                NotificationManager.IMPORTANCE_DEFAULT,
            )
            channel.description ="مناسبت های مخصوص شما رو بهتون یادآوری میکنیم"
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}