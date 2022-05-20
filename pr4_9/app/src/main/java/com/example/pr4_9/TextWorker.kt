package com.example.pr4_9

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class TextWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams)  {
    val l:Char = 'r'
    val j:Char = 'f'
    val k:Char = 'i'
    val p:Char = 'n'
    val t:Char = 'e'
    val m:Char = 'd'
    val s:String = "friend"
    var c:String = ""

    override fun doWork(): Result {
        Log.d("test_worker","text_worker_start")

        for (i in s.indices) {
            if(l==s[i]){
                c+=l
            }
            if(j==s[i]){
                c+=j
            }
            if(k==s[i]){
                c+=k
            }
            if(p==s[i]){
                c+=p
            }
            if(t==s[i]){
                c+=t
            }
            if(m==s[i]){
                c+=m
            }
        }

        val d = Data.Builder()
            .putString("data_is", c)
            .build()

        onStopped()
        return Result.success(d)
    }

    override fun onStopped() {
        super.onStopped()
        WorkManager.getInstance().cancelAllWorkByTag("process1")
        Log.d("test_worker","text_worker_stop")
    }
}