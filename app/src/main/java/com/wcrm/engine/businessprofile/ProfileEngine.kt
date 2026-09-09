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
            val activeProfile = registry.requireSingleEnabled()
            val runtime = BusinessProfileLoader().load(activeProfile, schemaLoader)

            // این مرحله تضمین می‌کند همه schemaIds پروفایل فعال واقعاً موجود هستند.
            require(runtime.schemaIds.size == activeProfile.schemaIds.size) {
                "تعداد Schemaهای Runtime با تعریف Profile سازگار نیست."
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
