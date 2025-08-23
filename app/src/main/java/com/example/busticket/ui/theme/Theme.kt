package com.example.busticket.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = androidx.compose.ui.graphics.Color(0xFF1976D2),
    primaryVariant = androidx.compose.ui.graphics.Color(0xFF1565C0),
    secondary = androidx.compose.ui.graphics.Color(0xFFFFA000)
)

// You can add light/dynamic color palettes here for future extensibility

@Composable
fun BusTicketTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = androidx.compose.material.Typography(),
        shapes = androidx.compose.material.Shapes(),
        content = content
    )
}
