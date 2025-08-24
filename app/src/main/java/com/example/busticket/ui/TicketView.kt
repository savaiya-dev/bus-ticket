package com.example.busticket.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.busticket.R
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun TicketView(zone: Int, color: Color) {
    var showQr by remember { mutableStateOf(false) }
    var timeLeft by remember { mutableStateOf(8 * 60 * 60 * 1000L) } // 8 hours in ms
    val formatter = remember { SimpleDateFormat("EEE, MMM d, hh:mm:ss a", Locale.getDefault()) }
    val now = remember { Date() }
    val expiry = remember { Date(now.time + timeLeft) }

    // Timer
    LaunchedEffect(Unit) {
        while (timeLeft > 0) {
            delay(1000)
            timeLeft -= 1000
        }
    }

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(color),
    ) {
        Column(
            modifier = Modifier
                .background(color)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("AUG2025", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White, letterSpacing = 2.sp)
            Text("STUDENT", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
            Spacer(Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .clickable { showQr = !showQr }
                    .semantics { contentDescription = if (showQr) "QR Code enlarged" else "Tap to enlarge QR Code" },
                contentAlignment = Alignment.Center
            ) {
                if (showQr) {
                    Image(
                        painter = painterResource(id = R.drawable.your_qr_code_image),
                        contentDescription = "QR Code image",
                        modifier = Modifier.size(100.dp),
                        contentScale = ContentScale.Fit
                    )
                } else {
                    Text("QR Code\nTap to enlarge", textAlign = TextAlign.Center, color = color, fontSize = 14.sp)
                }
            }
            Spacer(Modifier.height(8.dp))
            Text("BUS INTERSTATE PASS", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
            Text("$zone ZONES", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.White)
            Spacer(Modifier.height(8.dp))
            Text(formatter.format(now), color = Color.White, fontSize = 14.sp)
            Text("Expires in", color = Color.White, fontSize = 12.sp)
            val hours = (timeLeft / (1000 * 60 * 60)).toInt()
            val minutes = ((timeLeft / (1000 * 60)) % 60).toInt()
            val seconds = ((timeLeft / 1000) % 60).toInt()
            Text(String.format("%02d:%02d:%02d", hours, minutes, seconds), color = Color(0xFFFFEB3B), fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.bottom),
                contentDescription = "Decorative bottom image for ticket",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                contentScale = ContentScale.FillWidth
            )
        }
    }
}
