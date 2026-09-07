package com.wbeauty.crm.business_profile

/*
================================================
نام فایل:
BusinessModuleDefinition.kt

وظیفه:
تعریف ساختار استاندارد Module در CRM.

ارتباط:
Business Profile مشخص می‌کند کدام Module ها فعال باشند.

نکات توسعه:
Module دارای منطق، Workflow و فرآیند است. اطلاعات ساده باید Attribute Schema باشد.
================================================
*/

data class BusinessModuleDefinition(
    val module: ModuleType,
    val enabled: Boolean = true
)
