package com.wbeauty.crm.business_profile.profiles

import com.wbeauty.crm.business_profile.CRMIndustryType

/*
نام فایل:
RealEstate001Profile.kt

وظیفه:
تعریف CRM املاک.

نکات توسعه:
Property و Contract ماژول هستند و مشخصات ملک باید Schema جدا باشد.
*/
object RealEstate001Profile {
    const val id = "realestate_001"
    val industry = CRMIndustryType.REAL_ESTATE
    val enabledModules = listOf("CUSTOMER", "LEAD", "PROPERTY", "CONTRACT")
    val customerAttributes = listOf("property_interest")
}
