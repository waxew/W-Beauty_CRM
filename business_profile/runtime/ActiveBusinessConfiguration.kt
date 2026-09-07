/*
================================================
نام فایل:
ActiveBusinessConfiguration.kt

وظیفه:
نگهداری تنظیمات Business Profile فعال در زمان اجرای برنامه.

ارتباط:
این کلاس بین Resolver و Module/Schema Runtime قرار می‌گیرد.

نکات توسعه:
اطلاعات اختصاصی کسب‌وکار نباید داخل Core Entity قرار گیرد.
================================================
*/

package com.wbeauty.crm.business_profile.runtime

import com.wbeauty.crm.business_profile.ModuleType
import com.wbeauty.crm.business_profile.AttributeSchema

/**
 * تنظیمات نهایی یک نمونه CRM در زمان اجرا
 */
data class ActiveBusinessConfiguration(
    val businessId: String,
    val enabledModules: List<ModuleType>,
    val enabledSchemas: List<AttributeSchema>
)
