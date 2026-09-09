package com.wcrm.engine.businessprofile

class ProfileRegistry {
    private val profiles = mutableMapOf<String, BusinessProfile>()

    fun register(profile: BusinessProfile) {
        profiles[profile.id] = profile
    }

    fun get(id: String): BusinessProfile? = profiles[id]

    fun all(): List<BusinessProfile> = profiles.values.toList()

    /** فقط Profileهایی که برنامه‌نویس enabled=true کرده است. */
    fun enabled(): List<BusinessProfile> = profiles.values.filter { it.enabled }

    /**
     * برای خروجی‌های اختصاصی که باید فقط یک ماهیت کسب‌وکار داشته باشند.
     * اگر هیچ Profile یا بیش از یک Profile فعال باشد، پیکربندی معتبر نیست.
     */
    fun requireSingleEnabled(): BusinessProfile {
        val active = enabled()
        require(active.size == 1) {
            "Exactly one BusinessProfile must be enabled; found ${active.size}."
        }
        return active.single()
    }
}
