package com.example.pr4_9

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import androidx.work.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button:Button = findViewById(R.id.clicker)
        val button1:Button = findViewById(R.id.startprocess)

        button.setOnClickListener {
            count++
            button.text = count.toString()
        }

        button1.setOnClickListener {
            if(count>0){
                val data = Data.Builder()
                    .putInt("count", count)
                    .build()
                val process1: OneTimeWorkRequest = OneTimeWorkRequest.Builder(TextWorker::class.java)
                    .build()
                val process2: OneTimeWorkRequest = OneTimeWorkRequestBuilder<LongWorker>()
                    .setInputData(data)
                    .build()
                WorkManager.getInstance(this)
                    .beginWith(process1)
                    .then(process2)
                    .enqueue()
            }else{
                val process1: OneTimeWorkRequest = OneTimeWorkRequest.Builder(TextWorker::class.java)
                    .build()
                val process2: OneTimeWorkRequest = OneTimeWorkRequestBuilder<LongWorker>()
                    .build()
                WorkManager.getInstance(this)
                    .beginWith(process1)
                    .then(process2)
                    .enqueue()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        WorkManager.getInstance().cancelAllWork()
    }
}

