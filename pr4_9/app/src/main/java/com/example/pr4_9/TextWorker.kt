package com.example.pr4_9

import android.content.Context
import android.util.Log
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class TextWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams)  {
    override fun doWork(): Result {
        Log.d("test_worker","text_worker_start")

        onStopped()
        return Result.success()
    }

    override fun onStopped() {
        super.onStopped()
        WorkManager.getInstance().cancelAllWorkByTag("process1")
        Log.d("test_worker","text_worker_stop")
    }
}