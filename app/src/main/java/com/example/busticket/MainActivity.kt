package com.example.busticket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.busticket.ui.TicketApp
import com.example.busticket.ui.theme.BusTicketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusTicketTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    TicketApp()
                }
            }
        }
    }
}
