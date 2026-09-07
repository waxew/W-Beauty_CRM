package com.wcrm.engine.customfield

/**
 * نام فایل: CustomFieldValue.kt
 * وظیفه: نگهداری مقدار فیلدهای پویا برای Entity ها.
 * ارتباط: اتصال بین Core Entity و Attribute Schema.
 * نکات توسعه: اطلاعات صنعتی در این لایه نگهداری می‌شوند.
 */
data class CustomFieldValue(
    val entityId: String,
    val fieldKey: String,
    val value: String
)
