package ru.mirea.pr3_2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val value:EditText = findViewById(R.id.editText)
        val button:Button = findViewById(R.id.button)
        val radioChoice:RadioGroup = findViewById(R.id.radioGroup)

        button.setOnClickListener() {
            var id: Int = radioChoice.checkedRadioButtonId
            when (id) {
                R.id.radio_web -> {
                    var web: String = "https://${value.text.toString().trim()}"
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(web)))
                }
                R.id.radio_geo -> {
                    try {
                        var numbers = value.text.toString().split(",").toTypedArray()
                        startActivity(Intent(Intent.ACTION_VIEW,
                            Uri.parse("geo:${numbers[0]},${numbers[1]}")))
                    }catch (nfe: ArrayIndexOutOfBoundsException){
                        Toast.makeText(applicationContext, "Неправильный ввод!", Toast.LENGTH_SHORT).show()
                    }
                }
                R.id.radio_phone -> {
                    try {
                        var number: Int = value.text.toString().toInt()
                        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")))
                    }catch (nfe: NumberFormatException){
                        Toast.makeText(applicationContext, "Неправильный ввод!", Toast.LENGTH_SHORT).show()
                    }
                }
                else -> {
                    try {
                        var number: Int = value.text.toString().toInt()
                        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")))
                    } catch (nfe: NumberFormatException) {
                        try {
                            var numbers = value.text.toString().split(",").toTypedArray()
                            startActivity(Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:${numbers[0]},${numbers[1]}")))
                        } catch (nfe: ArrayIndexOutOfBoundsException) {
                            var web: String = "https://${value.text.toString().trim()}"
                            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(web)))
                        }
                    }
                }
            }
        }
    }
}