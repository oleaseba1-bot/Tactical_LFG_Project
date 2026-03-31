package com.seba.tacticallfg.data

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.auth.Auth // O Auth si usas la versión más nueva

val supabase = createSupabaseClient(
    supabaseUrl = "https://xdhpbfezaemacvtfsyec.supabase.co",
    supabaseKey = "sb_publishable_ZJ1ztZqrwia0TKUSByyt7A_EzFZ6Vmp"
) {
    install(Postgrest)
    install(Auth)
}
