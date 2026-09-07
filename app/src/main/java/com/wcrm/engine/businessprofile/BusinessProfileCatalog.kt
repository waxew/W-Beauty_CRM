package com.wcrm.engine.businessprofile

/**
 * Initial catalog entry point for supported business configurations.
 * Business-specific behavior remains outside the CRM core.
 */
object BusinessProfileCatalog {
    val supportedProfiles = listOf(
        "mobile_store",
        "beauty_center",
        "jewelry_store",
        "auto_parts",
        "home_appliance",
        "book_store",
        "grocery",
        "pet_store",
        "boutique",
        "omnichannel"
    )
}
