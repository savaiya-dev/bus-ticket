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
fun AdminPanel(zone: Int, color: Color, onZoneChange: (Int) -> Unit, onColorChange: (Color) -> Unit) {
    val zoneState = remember { mutableStateOf(zone.toString()) }
    val colorState = remember { mutableStateOf("#${color.value.toLong().toString(16).padStart(8, '0')}") }
    val colorError = remember { mutableStateOf(false) }

    Column(Modifier.padding(16.dp)) {
        Text("Admin Controls", color = Color.Gray)
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = zoneState.value,
            onValueChange = {
                zoneState.value = it
                it.toIntOrNull()?.let(onZoneChange)
            },
            label = { Text("Zone Number") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            value = colorState.value,
            onValueChange = {
                colorState.value = it
                colorError.value = false
                runCatching {
                    onColorChange(Color(android.graphics.Color.parseColor(it)))
                }.onFailure { colorError.value = true }
            },
            label = { Text("Ticket Color (Hex)") },
            isError = colorError.value,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            placeholder = { Text("e.g. #1976D2") },
            supportingText = { if (colorError.value) Text("Invalid color code", color = Color.Red) else Text("Format: #RRGGBB or #AARRGGBB") }
        )
    }
}
