package com.wcrm.engine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import com.wcrm.engine.navigation.AppNavigation
import com.wbeauty.crm.ui.theme.WBeautyTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WBeautyTheme {
                AppNavigation()
            }
        }
    }
}
