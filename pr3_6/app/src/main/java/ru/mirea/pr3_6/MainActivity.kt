package ru.mirea.pr3_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val defFragment1: ColorListFragment = ColorListFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment1, defFragment1)
            .commit()

        val defFragment2: ColoredFragment = ColoredFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment2, defFragment2)
            .commit()
    }
}