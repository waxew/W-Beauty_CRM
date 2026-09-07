package com.wcrm.engine.businessprofile.profiles.auto_parts

import com.wcrm.engine.businessprofile.BusinessProfile

object ProfileConfig {
    val profile = BusinessProfile(
        id = "auto_parts",
        enabledModules = listOf("CRM", "SALES", "INVENTORY", "REPAIR")
    )
}
