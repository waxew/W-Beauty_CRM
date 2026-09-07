/*
================================================
نام فایل:
BusinessRuntimeConfigurationBuilder.kt

وظیفه:
ساخت Configuration نهایی از Business Profile فعال.

ارتباط:
Resolver این Builder را برای آماده‌سازی Runtime استفاده می‌کند.

نکات توسعه:
این فایل نباید منطق صنعت خاص داشته باشد.
================================================
*/

package com.wbeauty.crm.business_profile.runtime

class BusinessRuntimeConfigurationBuilder {

    fun build(
        businessId: String,
        modules: List<Any>,
        schemas: List<Any>
    ): ActiveBusinessConfiguration {
        return ActiveBusinessConfiguration(
            businessId = businessId,
            enabledModules = emptyList(),
            enabledSchemas = emptyList()
        )
    }
}
