package com.wcrm.engine.runtime.shared

import com.wcrm.engine.businessprofile.BusinessModule
import com.wcrm.engine.businessprofile.BusinessProfile

/**
 * وضعیت Runtime فعال برنامه.
 * این Context منبع واحد UI برای تشخیص پروفایل، ماژول‌ها و فیلدهای اختصاصی است.
 */
data class RuntimeContext(
    val profile: BusinessProfile,
    val enabledModules: Set<BusinessModule> = profile.modules
)
