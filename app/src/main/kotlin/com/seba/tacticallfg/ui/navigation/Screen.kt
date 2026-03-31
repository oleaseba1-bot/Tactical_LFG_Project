package com.seba.tacticallfg.ui.navigation

sealed class Screen(val route: String, val title: String) {
    object LFG : Screen("lfg", "Buscar")
    object Profile : Screen("profile", "Perfil")
}
