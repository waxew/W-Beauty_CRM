package com.wbeauty.crm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WBeautyApp()
        }
    }
}

@Composable
fun WBeautyApp() {
    Text(text = "W-Beauty CRM")
}
