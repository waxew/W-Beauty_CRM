package com.wcrm.engine.runtime

import com.wcrm.engine.businessprofile.BusinessProfile
import com.wcrm.engine.businessprofile.BusinessProfileCatalog

/**
 * Registry مرکزی Profileهای کسب‌وکار در Runtime.
 *
 * هر ده Profile از کاتالوگ مرکزی ثبت می‌شوند و Profile پیش‌فرض همان Profileی است
 * که برنامه‌نویس با enabled=true مشخص کرده است. کاربر نهایی نوع کسب‌وکار را انتخاب نمی‌کند.
 */
class BusinessRegistry {
    private val profiles = mutableMapOf<String, BusinessProfile>()

    init {
        BusinessProfileCatalog.allProfiles.forEach(::register)
    }

    fun register(profile: BusinessProfile) {
        profiles[profile.id] = profile
    }

    fun getProfile(id: String): BusinessProfile? = profiles[id]

    fun getAllProfiles(): List<BusinessProfile> = profiles.values.toList()

    fun getEnabledProfiles(): List<BusinessProfile> = profiles.values.filter { it.enabled }

    /**
     * در Build اختصاصی دقیقاً یک Profile باید فعال باشد؛ در غیر این صورت پیکربندی خطا دارد.
     */
    fun getDefaultProfile(): BusinessProfile = BusinessProfileCatalog.requireActiveProfile()
}
