package com.wbeauty.crm.business_profile

/**
 * نگهدارنده Business Profile فعال در زمان اجرای برنامه.
 */
object BusinessRegistry {
    private var activeProfile: BusinessProfile? = null

    fun initialize(profile: BusinessProfile) {
        activeProfile = profile
        AttributeSchemaRegistry.initialize(profile.attributeSchemas)
    }

    fun getActiveProfile(): BusinessProfile? = activeProfile

    fun requireActiveProfile(): BusinessProfile =
        requireNotNull(activeProfile) { "Business profile has not been initialized." }
}
