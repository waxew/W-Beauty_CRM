package com.wcrm.engine.runtime

import com.wcrm.engine.businessprofile.BusinessProfile

/**
 * Registry for available business profiles.
 * Business types are configuration, not core logic.
 */
class BusinessRegistry {
    private val profiles = mutableMapOf<String, BusinessProfile>()

    fun register(profile: BusinessProfile) {
        profiles[profile.id] = profile
    }

    fun getProfile(id: String): BusinessProfile? {
        return profiles[id]
    }

    fun getDefaultProfile(): BusinessProfile {
        return profiles.values.firstOrNull() ?: BusinessProfile(id = "default")
    }
}
