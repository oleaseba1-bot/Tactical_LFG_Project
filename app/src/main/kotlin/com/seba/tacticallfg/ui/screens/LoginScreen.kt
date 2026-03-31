package com.seba.tacticallfg.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seba.tacticallfg.ui.theme.ValorantDarkGray
import com.seba.tacticallfg.ui.theme.ValorantRed

@Composable
fun TacticalShield(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(100.dp)) {
        val path = Path().apply {
            moveTo(size.width * 0.5f, size.height * 0.1f) // Top center
            lineTo(size.width * 0.9f, size.height * 0.3f) // Right shoulder
            lineTo(size.width * 0.8f, size.height * 0.8f) // Bottom right
            lineTo(size.width * 0.5f, size.height * 0.95f) // Bottom point
            lineTo(size.width * 0.2f, size.height * 0.8f) // Bottom left
            lineTo(size.width * 0.1f, size.height * 0.3f) // Left shoulder
            close()
        }
        drawPath(path = path, color = ValorantRed)
    }
}

@Composable
fun LoginScreen(onLoginClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(ValorantDarkGray, Color.Black)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TacticalShield()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tactical LFG",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = ValorantRed
            )

            Spacer(modifier = Modifier.height(48.dp))

            Button(
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text(
                    text = "Iniciar sesión con Google",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
