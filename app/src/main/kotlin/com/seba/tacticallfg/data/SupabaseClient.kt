package com.seba.tacticallfg.data

import io.github.jan_tennert.supabase.createSupabaseClient
import io.github.jan_tennert.supabase.postgrest.Postgrest
import io.github.jan_tennert.supabase.gotrue.GoTrue

val supabase = createSupabaseClient(
    supabaseUrl = "https://xdhpbfezaemacvtfsyec.supabase.co",
    supabaseKey = "sb_publishable_ZJ1ztZqrwia0TKUSByyt7A_EzFZ6Vmp"
) {
    install(Postgrest)
    install(GoTrue)
}
