package ru.mirea.pr3_1

import android.content.Intent
import android.content.OperationApplicationException
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.ArithmeticException
import java.lang.NumberFormatException
import kotlin.random.Random


class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result:TextView = findViewById(R.id.result)
        val butSmaller:Button = findViewById(R.id.butSmaller)
        val butBigger:Button = findViewById(R.id.butBigger)
        var range1: Int = 0
        var range2: Int = 0
        try {
            range1 = intent.getStringExtra("range1").toString().toInt()
            range2= intent.getStringExtra("range2").toString().toInt()
            if (range1>=range2){
                err()
            }else{
                var number = Random.nextInt(range1, range2+1)
                result.text=number.toString()
                butSmaller.setOnClickListener{
                    range2=number
                    number = Random.nextInt(range1, range2+1)
                    result.text=number.toString()
                }
                butBigger.setOnClickListener{
                    range1=number
                    number = Random.nextInt(range1, range2+1)
                    result.text=number.toString()
                }
            }
        }catch (nfe:NumberFormatException){
            err()
        }
    }

    private fun err(){
        Toast.makeText(this, "Не правильный ввод данных!", Toast.LENGTH_SHORT).show()
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}