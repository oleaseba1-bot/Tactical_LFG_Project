plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services") // <-- Añade esta línea
}

android {
    namespace = "com.seba.tacticallfg"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.seba.tacticallfg"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")

    // --- Navegación ---
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // --- Firebase y Google Auth ---
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.android.gms:play-services-auth:20.7.0")

// --- Supabase ---
implementation(platform("io.github.jan-tennert.supabase:bom:3.0.0")) 
implementation("io.github.jan-tennert.supabase:postgrest-kt")
implementation("io.github.jan-tennert.supabase:auth-kt") 
implementation("io.github.jan-tennert.supabase:realtime-kt") 
implementation("io.ktor:ktor-client-cio:2.3.7")
}
