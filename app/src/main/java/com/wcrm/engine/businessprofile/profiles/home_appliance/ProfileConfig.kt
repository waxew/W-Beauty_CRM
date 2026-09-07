package com.wcrm.engine.businessprofile.profiles.home_appliance

import com.wcrm.engine.businessprofile.BusinessProfile

object ProfileConfig {
    val profile = BusinessProfile(
        id = "home_appliance",
        enabledFeatures = listOf("CRM", "SALES", "INVENTORY", "WARRANTY")
    )
}
