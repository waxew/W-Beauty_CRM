package com.wbeauty.crm.business_profile

/**
 * نام فایل: BusinessProfile.kt
 *
 * وظیفه:
 * قرارداد اصلی تعریف مشخصات یک CRM Instance.
 *
 * ارتباط:
 * Core CRM فقط این Interface را می‌شناسد و هیچ شناختی از صنعت‌ها ندارد.
 *
 * نکات توسعه:
 * اطلاعات هر سازمان باید در profiles قرار بگیرد و نباید داخل Core نوشته شود.
 */

interface BusinessProfile {
    val id: String
    val industry: CRMIndustryType
    val crmName: String
    val companyName: String
    val packageName: String
    val enabledModules: Set<String>
}
