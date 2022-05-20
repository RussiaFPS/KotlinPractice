package com.example.pr4_9

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class LongWorker(appContext: Context, params: WorkerParameters) : CoroutineWorker(appContext, params) {
    override suspend fun doWork(): Result {
        Log.d("test_worker","long_worker_start")

        val data1: String = inputData.getString("data_is")?:"none"
        val data2:Int = inputData.getInt("count",100)
        var p:Long = 0

        for(i in 1..data1.length*10000){
            for(j in 1..data2) {
                p+=i/j
            }
        }

        Log.d("test_worker","long_worker_stop with rezult $p")
        return Result.success()
    }
}