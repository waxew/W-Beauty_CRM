/*
================================================
نام فایل:
BusinessProfileResolver.kt

وظیفه:
انتخاب Profile فعال بر اساس شناسه کسب و کار.

ارتباط:
بین BusinessRegistry و Runtime قرار می‌گیرد.

نکات توسعه:
هیچ منطق صنعتی نباید در این کلاس قرار گیرد.
================================================
*/

package com.wbeauty.crm.business_profile

class BusinessProfileResolver {

    fun resolve(businessId: String): String {
        return businessId
    }
}
