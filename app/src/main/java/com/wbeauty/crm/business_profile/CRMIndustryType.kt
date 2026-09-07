package com.wbeauty.crm.business_profile

/**
 * نام فایل: CRMIndustryType.kt
 *
 * وظیفه:
 * تعریف نوع صنعت‌هایی که می‌توانند از CRM Core Engine استفاده کنند.
 *
 * ارتباط:
 * توسط BusinessProfile و BusinessRegistry برای انتخاب تنظیمات هر CRM Instance استفاده می‌شود.
 *
 * نکات توسعه:
 * صنعت جدید نباید باعث تغییر در Core CRM شود؛ فقط یک مقدار جدید به این Enum اضافه می‌شود.
 */

enum class CRMIndustryType {
    SALES_COMPANY,
    CLINIC,
    BEAUTY_CENTER,
    REAL_ESTATE,
    SERVICE_COMPANY
}
