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

    /** خروجی مرتب برای رفتار قابل پیش‌بینی در تست و لاگ. */
    fun all(): List<BusinessProfile> = profiles.values.sortedBy { it.id }

    /** فقط Profileهای فعال را برمی‌گرداند. */
    fun enabled(): List<BusinessProfile> = all().filter { it.enabled }

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
        private val validIdPattern = Regex("^[a-z0-9][a-z0-9_-]*$")

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
                ProfileJsonParser.parse(json).also { profile ->
                    validateProfile(profile, fileName)
                }
            }

            val duplicateIds = loaded.groupingBy { it.id }.eachCount().filterValues { it > 1 }.keys
            require(duplicateIds.isEmpty()) { "شناسه تکراری Business Profile: $duplicateIds" }

            return ProfileRegistry(loaded.associateBy { it.id })
        }

        /**
         * اعتبارسنجی مستقل هر Profile قبل از ورود به Registry.
         * هدف این است که خطای کانفیگ در زمان شروع برنامه شناسایی شود، نه وسط یک عملیات کاربر.
         */
        private fun validateProfile(profile: BusinessProfile, fileName: String) {
            require(profile.id.isNotBlank()) { "شناسه Profile در فایل $fileName خالی است." }
            require(validIdPattern.matches(profile.id)) {
                "شناسه Profile '${profile.id}' در فایل $fileName معتبر نیست. فقط حروف کوچک انگلیسی، عدد، _ و - مجاز است."
            }
            require(profile.name.isNotBlank()) { "نام Profile '${profile.id}' خالی است." }

            val duplicateModules = profile.modules.groupingBy { it }.eachCount().filterValues { it > 1 }.keys
            require(duplicateModules.isEmpty()) {
                "ماژول تکراری در Profile '${profile.id}': $duplicateModules"
            }

            val duplicateSchemas = profile.schemaIds.groupingBy { it }.eachCount().filterValues { it > 1 }.keys
            require(duplicateSchemas.isEmpty()) {
                "Schema تکراری در Profile '${profile.id}': $duplicateSchemas"
            }

            require(profile.modules.none { it.isBlank() }) {
                "Profile '${profile.id}' شامل شناسه ماژول خالی است."
            }
            require(profile.schemaIds.none { it.isBlank() }) {
                "Profile '${profile.id}' شامل شناسه Schema خالی است."
            }
        }
    }
}
