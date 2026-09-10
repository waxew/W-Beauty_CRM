package com.wcrm.engine.core.config

/**
 * پیکربندی مرکزی برنامه.
 *
 * هدف این فایل نگهداری اطلاعات قابل تغییر برنامه بدون وابستگی به کدهای اصلی است.
 * برای ساخت نسخه‌های مستقل از برنامه می‌توان مقادیر این لایه را تغییر داد.
 */
object AppConfig {

    /** اطلاعات هویت برنامه */
    object Identity {
        const val appName: String = "W-CRM"
        const val appVersion: String = "1.0.0"
        const val appIcon: String = "app_icon"
        const val logo: String = "app_logo"
    }

    /** تنظیمات تبلیغات */
    object Ads {
        const val enabled: Boolean = false
        const val provider: String = ""

        // در صورت فعال شدن VIP، تبلیغات تا پایان اشتراک نمایش داده نمی‌شود.
        const val disableForVip: Boolean = true
    }

    /** تنظیمات بررسی بروزرسانی */
    object Update {
        const val enabled: Boolean = true
        const val checkOnStartup: Boolean = true
    }

    /** تنظیمات قابلیت‌ها */
    object Features {
        const val businessProfilesEnabled: Boolean = true
        const val customFieldsEnabled: Boolean = true
    }
}
