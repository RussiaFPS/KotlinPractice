package com.example.pr4_6

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {
   private val mTimeBroadCastReceiver = TimeBroadcastReceiver()
    private val batteryReceiver = BatteryLevelReceiver()
    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReceiver(mTimeBroadCastReceiver,  IntentFilter(
                "android.intent.action.TIME_TICK")
        )
        registerReceiver(batteryReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(mTimeBroadCastReceiver)
        unregisterReceiver(batteryReceiver)
    }

    fun cancel_wait(view: View?) {
        onDestroy()
        Toast.makeText(applicationContext, R.string.toast_text, Toast.LENGTH_SHORT)
            .show()
    }

    private fun TimeBroadcastReceiver(): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent?) {
                if (intent?.action == Intent.ACTION_TIME_TICK) {
                    count++
                    val text:TextView = findViewById(R.id.print)
                    text.text = "время созерцания: $count мин."
                }
            }
        }
    }

    private fun BatteryLevelReceiver(): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val textView = findViewById<TextView>(R.id.print)
                val batteryStatus: Intent? = IntentFilter(Intent.ACTION_BATTERY_CHANGED).let { ifilter ->
                    context.registerReceiver(null, ifilter)
                }
                val batteryPct: Float? = batteryStatus?.let { intent ->
                    val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
                    val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
                    level * 100 / scale.toFloat()
                }
                if (batteryPct?.toBigDecimal()?: BigDecimal.ZERO <= (BigDecimal(15))){
                    try {
                        unregisterReceiver(mTimeBroadCastReceiver)
                    } catch (e: IllegalArgumentException) {
                        Log.e("Broadcast", "Time tick not registered", e)
                    }
                    textView.text = "накормите Ждуна,силы на исходе!"
                }
                else{
                    textView.text = resources.getString(R.string.text)
                }
            }
        }
    }
}