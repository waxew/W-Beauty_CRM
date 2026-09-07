package com.wbeauty.crm.business_profile

/**
 * وظیفه فایل:
 * تعریف قابلیت هایی که دارای منطق، فرآیند و Workflow هستند.
 *
 * ارتباط:
 * BusinessProfile مشخص می کند کدام Module ها فعال باشند.
 *
 * نکات توسعه:
 * Attribute های ساده نباید به این لیست اضافه شوند.
 * فقط قابلیت های مستقل مانند رزرو، فروش و وظایف اینجا قرار می گیرند.
 */
enum class ModuleType {
    CUSTOMER,
    LEAD,
    TASK,
    PIPELINE,
    APPOINTMENT,
    COMMUNICATION,
    REPORT,
    AUTOMATION,
    SALES,
    WARRANTY,
    REPAIR
}
