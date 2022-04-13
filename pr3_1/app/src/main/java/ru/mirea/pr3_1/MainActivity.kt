package ru.mirea.pr3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val range1:EditText = findViewById(R.id.range1)
        val range2:EditText = findViewById(R.id.range2)
        val sendRange:Button = findViewById(R.id.sendRange)

        sendRange.setOnClickListener {
            var intent = Intent(this, Result::class.java)
            intent.putExtra("range1", range1.text.toString())
            intent.putExtra("range2", range2.text.toString())
            startActivity(intent)
        }
    }
}