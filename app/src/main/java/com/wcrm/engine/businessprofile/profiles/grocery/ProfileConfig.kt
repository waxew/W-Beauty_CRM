package com.wcrm.engine.businessprofile.profiles.grocery

import com.wcrm.engine.businessprofile.BusinessProfile

object ProfileConfig {
    val profile = BusinessProfile(
        id = "grocery",
        enabledFeatures = listOf("CRM", "SALES", "INVENTORY", "MARKETING")
    )
}
