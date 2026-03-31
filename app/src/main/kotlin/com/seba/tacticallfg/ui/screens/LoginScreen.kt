package com.seba.tacticallfg.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seba.tacticallfg.R
import com.seba.tacticallfg.ui.theme.ValorantDarkGray
import com.seba.tacticallfg.ui.theme.ValorantRed

@Composable
fun TacticalShield(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(100.dp)) {
        val path = Path().apply {
            moveTo(size.width * 0.5f, size.height * 0.1f)
            lineTo(size.width * 0.9f, size.height * 0.3f)
            lineTo(size.width * 0.8f, size.height * 0.8f)
            lineTo(size.width * 0.5f, size.height * 0.95f)
            lineTo(size.width * 0.2f, size.height * 0.8f)
            lineTo(size.width * 0.1f, size.height * 0.3f)
            close()
        }
        drawPath(path = path, color = ValorantRed)
    }
}

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit // <--- PASO 1: Agregamos el parámetro
) {
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            TacticalShield()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tactical",
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = ValorantRed
            )
            Text(
                text = "LFG",
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )

            Spacer(modifier = Modifier.weight(1f))

            // Botón de Google (Firebase)
            Button(
                onClick = onLoginClick,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = "Google Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Iniciar sesión con Google",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para ir al Registro de Supabase
            OutlinedButton(
                onClick = onRegisterClick,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                shape = CircleShape,
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
            ) {
                Text(
                    text = "Crear cuenta con Email",
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}
