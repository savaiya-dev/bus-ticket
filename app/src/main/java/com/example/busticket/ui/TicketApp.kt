package com.example.busticket.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TicketApp() {
    var isAdmin by remember { mutableStateOf(false) }
    var zone by remember { mutableStateOf(2) }
    var color by remember { mutableStateOf(MaterialTheme.colors.primary) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bus Ticket") },
                actions = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("User", color = if (!isAdmin) Color.Yellow else Color.White)
                        Switch(checked = isAdmin, onCheckedChange = { isAdmin = it })
                        Text("Admin", color = if (isAdmin) Color.Yellow else Color.White, modifier = androidx.compose.ui.Modifier.padding(start = 8.dp))
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            if (isAdmin) {
                AdminPanel(zone, color, onZoneChange = { zone = it }, onColorChange = { color = it })
            } else {
                UserPanel(zone, onZoneChange = { zone = it })
            }
            TicketView(zone = zone, color = color)
        }
    }
}

// TODO: Implement AdminPanel, UserPanel, TicketView composables
