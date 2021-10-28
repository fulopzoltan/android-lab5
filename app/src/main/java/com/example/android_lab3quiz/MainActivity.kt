package com.example.android_lab3quiz
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

const val LOG_I_MAIN = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
    }

}