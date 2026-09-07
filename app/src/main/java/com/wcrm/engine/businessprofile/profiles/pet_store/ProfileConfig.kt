package com.wcrm.engine.businessprofile.profiles.pet_store

import com.wcrm.engine.businessprofile.BusinessProfile

object ProfileConfig {
    val profile = BusinessProfile(
        id = "pet_store",
        enabledFeatures = listOf("CRM", "SALES", "INVENTORY")
    )
}
