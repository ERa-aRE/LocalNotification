package com.example.localnotification

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.localnotification.domain.ArbitraryInfo




class NotificationService(private val context: Context) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    fun showNotification(info: ArbitraryInfo) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            2,
            activityIntent,
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0

        )
        val notification = NotificationCompat.Builder(context, Notification_Channel_ID)
            .setSmallIcon(R.drawable.baseline_date_range_24)
            .setContentTitle("یکی از مناسب های شما نزدیک است !")
            .setContentText("  3 روز تا : ${info.name}\n ${info.age}")
            .setOnlyAlertOnce(true)
            .setVibrate(longArrayOf(20))
            .setContentIntent(activityPendingIntent)
            /*.addAction(
                R.drawable.baseline_date_range_24,
                "Back to the App",

            )
*/
            .build()
        notificationManager.notify(
            1,
            notification
        )
    }


    companion object {
        const val Notification_Channel_ID = "notification_ID"
    }
}