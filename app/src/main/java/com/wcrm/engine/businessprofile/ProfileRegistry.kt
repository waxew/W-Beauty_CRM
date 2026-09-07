package com.wcrm.engine.businessprofile

class ProfileRegistry {
    private val profiles = mutableMapOf<String, BusinessProfile>()

    fun register(profile: BusinessProfile) {
        profiles[profile.id] = profile
    }

    fun get(id: String): BusinessProfile? = profiles[id]

    fun all(): List<BusinessProfile> = profiles.values.toList()
}
