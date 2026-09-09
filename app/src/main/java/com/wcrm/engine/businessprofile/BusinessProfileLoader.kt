package com.wcrm.engine.businessprofile

import android.content.Context
import com.wcrm.engine.customfield.SchemaLoader
import com.wcrm.engine.runtime.BusinessRuntime

/**
 * تبدیل Profile فعال به Runtime قابل مصرف توسط Core و UI.
 *
 * Profile و Schema از فایل‌های مستقل assets بارگذاری می‌شوند؛ بنابراین این کلاس
 * هیچ نام صنعت یا Schema مشخصی را Hardcode نمی‌کند.
 */
class BusinessProfileLoader {
    fun load(
        profile: BusinessProfile,
        schemaLoader: SchemaLoader? = null
    ): BusinessRuntime {
        val schemas = schemaLoader?.load(profile.schemaIds).orEmpty()
        return BusinessRuntime(
            businessId = profile.id,
            enabledModules = profile.modules,
            customSchemas = schemas.flatMap { it.fields },
            schemaIds = profile.schemaIds,
            uiConfig = profile.ui
        )
    }

    /** بارگذاری تنها Profile فعال نسخه به همراه تمام Schemaهای آن. */
    fun loadActive(context: Context): BusinessRuntime {
        val registry = ProfileRegistry.fromAssets(context)
        val active = registry.requireSingleEnabled()
        return load(active, SchemaLoader(context))
    }
}
