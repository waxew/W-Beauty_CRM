package com.wcrm.engine.businessprofile

import com.wcrm.engine.runtime.BusinessRuntime

/**
 * تبدیل Business Profile فعال به Runtime قابل مصرف توسط Core و UI.
 *
 * هیچ اطلاعات صنفی در این کلاس Hardcode نمی‌شود؛ تمام تنظیمات از خود Profile می‌آید.
 */
class BusinessProfileLoader {
    fun load(profile: BusinessProfile): BusinessRuntime {
        return BusinessRuntime(
            businessId = profile.id,
            enabledModules = profile.modules,
            customSchemas = emptyList(),
            schemaIds = profile.schemaIds,
            uiConfig = profile.ui
        )
    }

    /** بارگذاری مستقیم تنها Profile فعال تعریف‌شده توسط برنامه‌نویس. */
    fun loadActive(): BusinessRuntime = load(BusinessProfileCatalog.requireActiveProfile())
}
