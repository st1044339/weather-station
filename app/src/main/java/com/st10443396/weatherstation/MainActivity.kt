package com.st10443396.weatherstation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var etAppName: TextView? = null
    private var etName: TextView? = null
    private var etStudentNum: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etAppName = findViewById(R.id.etAppName)
        etName = findViewById(R.id.etName)
        etStudentNum = findViewById(R.id.etStudentNum)

        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnExitApp = findViewById<Button>(R.id.btnExitApp)
    }
}