package com.wcrm.business_profile

/**
 * تعریف استاندارد هر پروفایل کسب و کار
 *
 * اضافه کردن پروفایل جدید باید فقط با اضافه کردن یک Definition جدید انجام شود.
 */
data class BusinessProfileDefinition(
    val id: String,
    val displayName: String,
    val modules: List<String>,
    val customFields: List<String>,
    val enabled: Boolean = true
)
