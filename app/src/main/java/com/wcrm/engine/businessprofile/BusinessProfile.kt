package com.wcrm.engine.businessprofile

/**
 * تعریف مستقل هر نوع کسب‌وکار.
 *
 * enabled توسط برنامه‌نویس تنظیم می‌شود. در خروجی نهایی فقط Profileهایی که
 * enabled=true دارند قابل استفاده/نمایش هستند. برای نسخه‌های اختصاصی بهتر است
 * دقیقاً یک Profile فعال باشد.
 *
 * ui تنظیمات نمایشی، داشبورد، واژگان و فیلدهای اختصاصی همان کسب‌وکار را نگه می‌دارد.
 * Core نباید نوع صنعت را Hardcode کند و باید این اطلاعات را از Profile فعال بخواند.
 */
data class BusinessProfile(
    val id: String,
    val name: String = id,
    val enabled: Boolean = false,
    val enabledModules: List<String> = emptyList(),
    val enabledFeatures: List<String> = emptyList(),
    val schemaIds: List<String> = emptyList(),
    val visualProfileId: String = id,
    val dashboardProfileId: String = id,
    val terminologyProfileId: String = id,
    val ui: BusinessUiConfig? = null
) {
    /**
     * نمای سازگاری برای Profileهای قدیمی در زمان مهاجرت.
     */
    val modules: List<String>
        get() = if (enabledModules.isNotEmpty()) enabledModules else enabledFeatures
}
