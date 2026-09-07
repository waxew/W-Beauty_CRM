package com.wcrm.engine.businessprofile.profiles.omnichannel

import com.wcrm.engine.businessprofile.BusinessProfile

object ProfileConfig {
    val profile = BusinessProfile(
        id = "omnichannel",
        enabledModules = listOf("CRM", "SALES", "INVENTORY", "MARKETING", "ADS")
    )
}
