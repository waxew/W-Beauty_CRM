package com.wbeauty.crm.business_profile

/**
 * تعریف پیکربندی یک کسب‌وکار برای موتور CRM.
 * تفاوت‌های صنعت از طریق Module و Attribute Schema اعمال می‌شوند و Core وابسته به صنعت نیست.
 */
data class BusinessProfile(
    val businessId: String,
    val enabledModules: List<ModuleType> = emptyList(),
    val attributeSchemas: List<AttributeSchema> = emptyList()
)
