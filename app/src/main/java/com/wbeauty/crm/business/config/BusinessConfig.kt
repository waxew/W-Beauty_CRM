package com.wbeauty.crm.business.config

/**
 * Central business profile configuration.
 * All business-specific branding and texts should be provided here
 * instead of being hardcoded inside the CRM core.
 */
data class BusinessConfig(
    val id: String,
    val appName: String,
    val businessName: String,
    val packageName: String,
    val logoRes: Int? = null,
    val primaryColor: Long,
    val customerTitle: String,
    val reservationTitle: String
)
