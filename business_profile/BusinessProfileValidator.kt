/*
================================================
نام فایل:
BusinessProfileValidator.kt

وظیفه:
اعتبارسنجی ساختار Business Profile قبل از اجرا.

ارتباط:
با Business Registry و Runtime Initializer استفاده می‌شود.

نکات توسعه:
هیچ منطق صنعت خاصی نباید در این فایل قرار گیرد.
================================================
*/

package com.wbeauty.crm.business_profile

object BusinessProfileValidator {

    fun validate(profile: BusinessProfile): Boolean {
        return profile.id.isNotBlank() && profile.enabledModules.isNotEmpty()
    }
}
