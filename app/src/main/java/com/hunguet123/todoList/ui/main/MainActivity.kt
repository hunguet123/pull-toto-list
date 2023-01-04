package com.hunguet123.todoList.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hunguet123.todoList.R

import com.hunguet123.todoList.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frameMain, HomeFragment())
            .commit()
    }
}
