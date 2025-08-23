package com.example.busticket.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun UserPanel(zone: Int, onZoneChange: (Int) -> Unit) {
    val zoneState = remember { mutableStateOf(zone.toString()) }
    Column(Modifier.padding(16.dp)) {
        Text("Change Zone", color = Color.Gray)
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = zoneState.value,
            onValueChange = {
                zoneState.value = it
                it.toIntOrNull()?.let(onZoneChange)
            },
            label = { Text("Zone Number") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = { Text("e.g. 2") },
            supportingText = { Text("Enter a valid zone number") }
        )
    }
}
