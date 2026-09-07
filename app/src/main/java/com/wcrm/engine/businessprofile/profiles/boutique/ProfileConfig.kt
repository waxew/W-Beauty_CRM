package com.wcrm.engine.businessprofile.profiles.boutique

import com.wcrm.engine.businessprofile.BusinessProfile

object ProfileConfig {
    val profile = BusinessProfile(
        id = "boutique",
        enabledFeatures = listOf("CRM", "SALES", "INVENTORY", "MARKETING")
    )
}
