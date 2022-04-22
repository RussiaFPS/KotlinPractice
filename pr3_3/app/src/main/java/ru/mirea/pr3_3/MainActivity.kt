package ru.mirea.pr3_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        var reverseSortByName:Boolean = false
        var reverseSortBySex:Boolean = false
        var reverseSortByPhone:Boolean = false

        val sortByName: Button = findViewById(R.id.sortByName)
        val sortBySex: Button = findViewById(R.id.sortBySex)
        val sortByPhone: Button = findViewById(R.id.sortByPhone)
        val gson = GsonBuilder().create()
        var Model= gson.fromJson(jsonString,Array<Person>::class.java).toList()


        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)


        val adapter = CustomAdapter(Model)
        recyclerview.adapter = adapter


        sortByName.setOnClickListener{
            if (!reverseSortByName){
                 Model = Model.sortedBy { it.name }
                 reverseSortByName = true
            }else{
                Model = Model.sortedBy { it.name }.reversed()
                reverseSortByName = false
            }

            val adapter = CustomAdapter(Model)
            recyclerview.adapter = adapter
        }

        sortBySex.setOnClickListener{
            if (!reverseSortBySex){
                Model = Model.sortedBy { it.sex }
                reverseSortBySex = true
            }else{
                Model = Model.sortedBy { it.sex }.reversed()
                reverseSortBySex = false
            }

            val adapter = CustomAdapter(Model)
            recyclerview.adapter = adapter
        }

        sortByPhone.setOnClickListener{
            if (!reverseSortByPhone){
                Model = Model.sortedBy { it.phoneNumber }
                reverseSortByPhone = true
            }else{
                Model = Model.sortedBy { it.phoneNumber }.reversed()
                reverseSortByPhone = false
            }

            val adapter = CustomAdapter(Model)
            recyclerview.adapter = adapter
        }
    }
}