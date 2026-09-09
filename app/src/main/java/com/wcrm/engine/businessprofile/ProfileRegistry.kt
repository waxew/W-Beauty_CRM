package com.wcrm.engine.businessprofile

import android.content.Context

/**
 * رجیستری استاندارد Business Profileها.
 *
 * این رجیستری هیچ شناختی از نام صنایع ندارد. تمام Profileها از پوشه
 * assets/business_profiles خوانده می‌شوند؛ بنابراین افزودن Profile یازدهم
 * فقط با اضافه‌کردن فایل تعریف آن انجام می‌شود و Core تغییر نمی‌کند.
 */
class ProfileRegistry private constructor(
    private val profiles: Map<String, BusinessProfile>
) {
    fun get(id: String): BusinessProfile? = profiles[id]
    fun all(): List<BusinessProfile> = profiles.values.toList()
    fun enabled(): List<BusinessProfile> = profiles.values.filter { it.enabled }

    /** برای خروجی اختصاصی باید دقیقاً یک Profile فعال باشد. */
    fun requireSingleEnabled(): BusinessProfile {
        val active = enabled()
        require(active.size == 1) {
            "برای هر خروجی باید دقیقاً یک Business Profile با enabled=true وجود داشته باشد. تعداد فعلی: ${active.size}"
        }
        return active.single()
    }

    companion object {
        private const val PROFILE_ASSET_DIR = "business_profiles"

        /** تمام Profileها را بدون لیست Hardcode از assets کشف و بارگذاری می‌کند. */
        fun fromAssets(context: Context): ProfileRegistry {
            val names = context.assets.list(PROFILE_ASSET_DIR)
                ?.filter { it.endsWith(".json", ignoreCase = true) }
                ?.sorted()
                .orEmpty()

            require(names.isNotEmpty()) { "هیچ Business Profile در assets/$PROFILE_ASSET_DIR پیدا نشد." }

            val loaded = names.map { fileName ->
                val json = context.assets.open("$PROFILE_ASSET_DIR/$fileName")
                    .bufferedReader()
                    .use { it.readText() }
                ProfileJsonParser.parse(json)
            }

            val duplicateIds = loaded.groupingBy { it.id }.eachCount().filterValues { it > 1 }.keys
            require(duplicateIds.isEmpty()) { "شناسه تکراری Business Profile: $duplicateIds" }

            return ProfileRegistry(loaded.associateBy { it.id })
        }
    }
}
