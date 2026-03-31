package com.seba.tacticallfg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.seba.tacticallfg.ui.screens.LoginScreen
import com.seba.tacticallfg.ui.screens.ProfileScreen
import com.seba.tacticallfg.ui.theme.TacticalLFGTheme

class MainActivity : ComponentActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        // 1. Configuración de GoogleSignInClient
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("189012957884-tlfhtgbs7t6cnjiphb6ocg0bjnciodbq.apps.googleusercontent.com")
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        setContent {
            TacticalLFGTheme {
                var user by remember { mutableStateOf(auth.currentUser) }

                // 2. Definición del Launcher
                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.StartActivityForResult()
                ) { result ->
                    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                    try {
                        val account = task.getResult(ApiException::class.java)
                        account.idToken?.let { token ->
                            val credential = GoogleAuthProvider.getCredential(token, null)
                            auth.signInWithCredential(credential).addOnCompleteListener { taskResult ->
                                if (taskResult.isSuccessful) {
                                    user = auth.currentUser
                                }
                            }
                        }
                    } catch (e: Exception) {
                        // Manejo de errores
                    }
                }
                
                if (user != null) {
                    ProfileScreen()
                } else {
                    LoginScreen(onLoginClick = { 
                        launcher.launch(googleSignInClient.signInIntent) 
                    })
                }
            }
        }
    }
}
