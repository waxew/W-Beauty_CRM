package com.wcrm.core.config

/**
 * کانفیگ مرکزی برنامه
 *
 * هدف:
 * نگهداری اطلاعات ثابت برنامه در یک نقطه واحد
 * تا برای ساخت نسخه های مستقل نیاز به تغییر کدهای اصلی نباشد.
 */
data class AppConfig(
    val appIdentity: AppIdentityConfig,
    val ads: AdsConfig,
    val update: UpdateConfig
)

data class AppIdentityConfig(
    val appName: String,
    val versionName: String,
    val logo: String,
    val icon: String
)

data class AdsConfig(
    val enabled: Boolean,
    val hideForVip: Boolean
)

data class UpdateConfig(
    val enabled: Boolean,
    val updateSource: String
)
