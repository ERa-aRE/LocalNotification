package com.example.localnotification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.*
import java.util.concurrent.TimeUnit

class BootCompletedReceiver :BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action==Intent.ACTION_BOOT_COMPLETED)
        {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .build()
            val workRequest = PeriodicWorkRequest.Builder(
                Worker::class.java,
                1,
                TimeUnit.DAYS
            ).setConstraints(constraints)
                .addTag("first worker")
                .build()
            if (context != null) {
                WorkManager.getInstance(context)
                    .enqueueUniquePeriodicWork("first worker", ExistingPeriodicWorkPolicy.KEEP, workRequest)
            }



        }


    }


}