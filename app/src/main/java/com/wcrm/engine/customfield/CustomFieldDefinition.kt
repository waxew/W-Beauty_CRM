package com.wcrm.engine.customfield

/**
 * نام فایل: CustomFieldDefinition.kt
 * وظیفه: تعریف ساختار یک فیلد سفارشی در CRM.
 * ارتباط: توسط Custom Field Engine و Business Profile Runtime استفاده می‌شود.
 * نکات توسعه: هیچ Industry Field نباید داخل Core Entity قرار گیرد.
 */
data class CustomFieldDefinition(
    val key: String,
    val label: String,
    val type: CustomFieldType,
    val required: Boolean = false
)
