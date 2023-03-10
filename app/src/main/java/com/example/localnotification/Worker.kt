package com.example.localnotification

import android.content.Context
import androidx.work.WorkerParameters
import com.example.localnotification.domain.util.ArbitraryInfo


class Worker(context: Context, workerParameters: WorkerParameters) :
    androidx.work.Worker(context, workerParameters) {
    private val service = NotificationService(context)
    override fun doWork(): Result {
        service.showNotification(ArbitraryInfo("بزودی :",""))
        return Result.success()
    }
}