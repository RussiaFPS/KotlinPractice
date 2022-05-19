package com.example.pr4_9

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.work.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val count:Int = 0
    val data = Data.Builder()
        .putInt("count", 0)
        .build()
    val process1: OneTimeWorkRequest = OneTimeWorkRequest.Builder(TextWorker::class.java)
        .addTag("process1").build()
   /* val process2: OneTimeWorkRequest = OneTimeWorkRequestBuilder<LongWorker>()
        .setInputData(data)
        .build()*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WorkManager.getInstance(this).enqueue(process1)
    }
}

