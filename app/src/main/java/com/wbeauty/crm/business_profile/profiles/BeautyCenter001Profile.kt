package com.wbeauty.crm.business_profile.profiles

import com.wbeauty.crm.business_profile.CRMIndustryType

/*
نام فایل:
BeautyCenter001Profile.kt

وظیفه:
تعریف پروفایل CRM مخصوص مرکز زیبایی.

ارتباط:
توسط BusinessRegistry برای فعال کردن تنظیمات کسب‌وکار استفاده می‌شود.

نکات توسعه:
اطلاعات اختصاصی صنعت نباید وارد Core شود و فقط از طریق Module و Attribute Schema مدیریت می‌شود.
*/
object BeautyCenter001Profile {
    const val id = "beauty_center_001"
    val industry = CRMIndustryType.BEAUTY_CENTER
    val enabledModules = listOf("CUSTOMER", "RESERVATION", "SERVICE", "STAFF", "LOYALTY")
    val customerAttributes = listOf("skin_type", "hair_history")
}
