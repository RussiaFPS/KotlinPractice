package ru.mirea.pr3_5

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.caption)
        var check:Boolean = false

        val defFragment1: BlankFragmentRed = BlankFragmentRed.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment1, defFragment1)
            .commit()

        val defFragment2: BlankFragmentBlue = BlankFragmentBlue.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment2, defFragment2)
            .commit()

        button.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            check = if (check){
                fragmentTransaction.replace(R.id.fragment1,BlankFragmentRed())
                fragmentTransaction.replace(R.id.fragment2,BlankFragmentBlue())
                fragmentTransaction.commit()
                false
            }else{
                fragmentTransaction.replace(R.id.fragment1,BlankFragmentBlue())
                fragmentTransaction.replace(R.id.fragment2,BlankFragmentRed())
                fragmentTransaction.commit()
                true
            }
        }
    }

}