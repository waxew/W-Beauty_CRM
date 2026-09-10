package com.wcrm.engine.businessprofile

import android.content.Context
import com.wcrm.engine.customfield.SchemaLoader
import com.wcrm.engine.runtime.BusinessRuntime

/**
 * درگاه واحد Profile Engine.
 *
 * تمام بخش‌های برنامه باید Profile فعال و Runtime آن را از این کلاس دریافت کنند؛
 * نه اینکه مستقیماً فایل Profile یا Schema را بخوانند. این کار یک نقطه کنترل واحد
 * برای اعتبارسنجی، Registry، Schema Loader و Runtime ایجاد می‌کند.
 */
class ProfileEngine private constructor(
    val registry: ProfileRegistry,
    val schemaLoader: SchemaLoader,
    val activeProfile: BusinessProfile,
    val runtime: BusinessRuntime
) {
    companion object {
        fun create(context: Context): ProfileEngine {
            val appContext = context.applicationContext
            val registry = ProfileRegistry.fromAssets(appContext)
            val schemaLoader = SchemaLoader(appContext)

            /*
             * همه Profileها، حتی Profileهای غیرفعال، در زمان راه‌اندازی Audit می‌شوند.
             * در نتیجه اگر بعداً توسعه‌دهنده Profile دیگری را فعال کند، خطای Schema مخفی
             * تا زمان انتشار نسخه باقی نمی‌ماند.
             */
            registry.all().forEach { profile ->
                schemaLoader.validateReferences(profile.id, profile.schemaIds)
            }

            val activeProfile = registry.requireSingleEnabled()
            val runtime = BusinessProfileLoader().load(activeProfile, schemaLoader)

            // Runtime باید دقیقاً همان Schemaهایی را حمل کند که در Profile فعال تعریف شده‌اند.
            require(runtime.schemaIds == activeProfile.schemaIds) {
                "Schemaهای Runtime با تعریف Profile '${activeProfile.id}' سازگار نیستند."
            }

            // Runtime نباید ماژولی را حذف یا اضافه کند؛ منبع حقیقت همان Profile است.
            require(runtime.enabledModules == activeProfile.modules) {
                "ماژول‌های Runtime با تعریف Profile '${activeProfile.id}' سازگار نیستند."
            }

            return ProfileEngine(
                registry = registry,
                schemaLoader = schemaLoader,
                activeProfile = activeProfile,
                runtime = runtime
            )
        }
    }
}
