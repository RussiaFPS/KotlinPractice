package ru.mirea.pr3_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

        val jsonString = application.assets.open("input.json").bufferedReader().use{
            it.readText()
        }

        val gson = GsonBuilder().create()
        val Model= gson.fromJson(jsonString,Array<Person>::class.java).toList()


        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)


        val adapter = CustomAdapter(Model)
        recyclerview.adapter = adapter
    }
}