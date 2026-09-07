package com.wbeauty.crm.business_profile

/**
 * نام فایل: BusinessRegistry.kt
 *
 * وظیفه:
 * نگهداری و انتخاب Business Profile فعال برنامه.
 *
 * ارتباط:
 * Application و UI در آینده فقط از Registry برای دریافت Profile فعال استفاده می‌کنند.
 *
 * نکات توسعه:
 * تغییر صنعت نباید نیازمند تغییر Core باشد؛ فقط Profile فعال تغییر می‌کند.
 */

object BusinessRegistry {
    private lateinit var currentProfile: BusinessProfile

    fun initialize(profile: BusinessProfile) {
        currentProfile = profile
    }

    fun getCurrentProfile(): BusinessProfile {
        return currentProfile
    }
}
