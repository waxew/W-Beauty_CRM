package com.wcrm.engine
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
class MainActivity : ComponentActivity(){ override fun onCreate(b: Bundle?){super.onCreate(b);setContent{Surface(color=MaterialTheme.colorScheme.background){Text("W-CRM")}}}}