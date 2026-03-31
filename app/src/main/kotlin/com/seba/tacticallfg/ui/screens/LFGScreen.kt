package com.seba.tacticallfg.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.seba.tacticallfg.ui.theme.ValorantDarkGray
import com.seba.tacticallfg.ui.theme.ValorantRed

@Composable
fun LFGScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ValorantDarkGray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Buscar Jugadores (LFG)", color = Color.White, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        // Aquí irá el listado con Supabase en la siguiente fase
        Text("Próximamente: Lista de jugadores filtrada por rango", color = Color.White)
    }
}
