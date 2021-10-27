package com.example.android_lab3quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class GetStartedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)
        val personName = intent.getStringExtra("NAME")
        val name = findViewById<TextView>(R.id.name).apply {
            text=personName.toString()
        }
    }
}