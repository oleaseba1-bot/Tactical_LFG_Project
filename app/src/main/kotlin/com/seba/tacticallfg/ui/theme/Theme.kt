package com.seba.tacticallfg.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
    primary = ValorantRed,
    background = ValorantDarkGray,
    surface = ValorantDarkGray,
    onPrimary = White,
    onBackground = White,
    onSurface = White
)

@Composable
fun TacticalLFGTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColors,
        content = content
    )
}
