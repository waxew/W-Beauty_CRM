package com.wbeauty.crm.business_profile.profiles

import com.wbeauty.crm.business_profile.CRMIndustryType

/*
نام فایل:
Clinic001Profile.kt

وظیفه:
تعریف پروفایل CRM کلینیک.

ارتباط:
فعال کننده Module ها و Attribute Schema های کلینیک.

نکات توسعه:
اطلاعات پزشکی فقط Attribute Schema است و نباید در Customer Core قرار گیرد.
*/
object Clinic001Profile {
    const val id = "clinic_001"
    val industry = CRMIndustryType.CLINIC
    val enabledModules = listOf("CUSTOMER", "APPOINTMENT", "STAFF", "REPORT")
    val customerAttributes = listOf("blood_type", "medical_notes")
}
