package com.wbeauty.crm.business_profile

/*
================================================
نام فایل:
BusinessRuntimeInitializer.kt

وظیفه:
راه‌اندازی Runtime مربوط به Business Profile فعال.

ارتباط:
این کلاس بین BusinessRegistry، ModuleRegistry و AttributeSchemaRegistry ارتباط ایجاد می‌کند.

نکات توسعه:
Core نباید صنعت خاصی را بشناسد. تغییر کسب‌وکار فقط باید از طریق Profile انجام شود.
================================================
*/

object BusinessRuntimeInitializer {

    fun initialize(profile: BusinessProfile) {
        BusinessRegistry.initialize(profile)

        ModuleRegistry.initialize(
            profile.enabledModules
        )
    }
}
