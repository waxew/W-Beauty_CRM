package com.wcrm.engine.businessprofile.profiles.book_store

import com.wcrm.engine.businessprofile.BusinessProfile

object ProfileConfig {
    val profile = BusinessProfile(
        id = "book_store",
        enabledFeatures = listOf("CRM", "SALES", "INVENTORY")
    )
}
