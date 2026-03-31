package com.seba.tacticallfg.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.seba.tacticallfg.ui.theme.ValorantRed
import com.seba.tacticallfg.ui.theme.ValorantDarkGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    var username by remember { mutableStateOf("") }
    var riotId by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedRank by remember { mutableStateOf("Selecciona un rango") }
    val ranks = listOf("Plata 1", "Oro 2", "Diamante 3")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ValorantDarkGray)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Photo Placeholder (Code generated)
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(BorderStroke(2.dp, ValorantRed), CircleShape)
                .background(Color.Gray.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile Icon",
                modifier = Modifier.size(60.dp),
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Username
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = ValorantRed,
                unfocusedBorderColor = Color.White,
                focusedLabelColor = ValorantRed,
                unfocusedLabelColor = Color.White,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Riot ID
        OutlinedTextField(
            value = riotId,
            onValueChange = { riotId = it },
            label = { Text("Riot ID") },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = ValorantRed,
                unfocusedBorderColor = Color.White,
                focusedLabelColor = ValorantRed,
                unfocusedLabelColor = Color.White,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Range Dropdown
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedRank,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.fillMaxWidth().menuAnchor(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = ValorantDarkGray,
                    unfocusedContainerColor = ValorantDarkGray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedIndicatorColor = ValorantRed,
                    unfocusedIndicatorColor = Color.White
                )
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.background(ValorantDarkGray)
            ) {
                ranks.forEach { rank ->
                    DropdownMenuItem(
                        text = { Text(rank, color = Color.White) },
                        onClick = {
                            selectedRank = rank
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Update Button
        Button(
            onClick = { /* Handle Update */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = ValorantRed)
        ) {
            Text("ACTUALIZAR PERFIL", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = {
                // Cerramos la sesión de Firebase
                com.google.firebase.auth.FirebaseAuth.getInstance().signOut()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("CERRAR SESIÓN", color = Color.White.copy(alpha = 0.6f))
        }
        // <<< HASTA AQUÍ >>>
        
    } // Esta llave cierra la Column
}

