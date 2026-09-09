package com.wcrm.engine.customfield

/**
 * مجموعه فیلدهای سفارشی مربوط به یک Business Profile.
 * این مدل برای نگهداری Attribute های متغیر خارج از Core استفاده می‌شود.
 */
data class CustomFieldSchema(
    val id: String,
    val fields: List<CustomFieldDefinition> = emptyList()
)
