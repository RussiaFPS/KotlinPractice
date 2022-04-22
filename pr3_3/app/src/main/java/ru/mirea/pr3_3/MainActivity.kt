package ru.mirea.pr3_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import java.io.BufferedReader
import java.io.File
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text:TextView = findViewById(R.id.text)
        val jsonString = application.assets.open("input.json").bufferedReader().use{
            it.readText()
        }


        val gson = GsonBuilder().create()
        val Model= gson.fromJson(jsonString,Array<Person>::class.java).toList()

        text.text = Model[0].name
    }
}