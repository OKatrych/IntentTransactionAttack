package com.example.victimapp

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val textView = findViewById<TextView>(R.id.textView)
        findViewById<Button>(R.id.button).setOnClickListener {
            textView.text = textView.text.toString().toInt().inc().toString()
        }
    }
}