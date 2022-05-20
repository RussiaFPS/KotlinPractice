package com.example.pr4_9

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters

class TextWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams)  {
    private val l:Char = 'r'
    private val j:Char = 'f'
    private val k:Char = 'i'
    private val p:Char = 'n'
    private val t:Char = 'e'
    private val m:Char = 'd'
    private val s:String = "friend"
    private var c:String = ""

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

        Log.d("test_worker","text_worker_stop")
        return Result.success(Data.Builder().putString("data_is",c).build())
    }
}