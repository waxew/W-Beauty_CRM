package com.wcrm.engine.businessprofile

/**
 * Registry مرکزی پروفایل‌ها.
 * قانون پروژه: دقیقاً یک پروفایل باید فعال باشد؛ صفر یا بیش از یک مورد خطای پیکربندی است.
 */
object BusinessProfileRegistry {

    fun allProfiles(): List<BusinessProfile> = StoreProfiles.all

    fun activeProfile(): BusinessProfile {
        val enabledProfiles = StoreProfiles.all.filter { it.enabled }
        require(enabledProfiles.size == 1) {
            "پیکربندی Business Profile نامعتبر است: باید دقیقاً یک پروفایل فعال باشد، تعداد فعلی=${enabledProfiles.size}"
        }
        return enabledProfiles.single()
    }

    fun findById(id: String): BusinessProfile? = StoreProfiles.all.firstOrNull { it.id == id }

    fun enabledModules(): Set<BusinessModule> = activeProfile().modules

    fun isModuleEnabled(module: BusinessModule): Boolean = module in enabledModules()
}
