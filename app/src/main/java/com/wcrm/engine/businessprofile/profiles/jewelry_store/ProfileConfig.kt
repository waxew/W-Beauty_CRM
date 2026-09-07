package com.wcrm.engine.businessprofile.profiles.jewelry_store

import com.wcrm.engine.businessprofile.BusinessProfile

object ProfileConfig {
    val profile = BusinessProfile(
        id = "jewelry_store",
        enabledModules = listOf("CRM", "SALES", "INVENTORY")
    )
}
