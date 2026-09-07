package com.wcrm.engine.customfield

/**
 * نام فایل: CustomFieldType.kt
 * وظیفه: تعیین نوع داده فیلدهای سفارشی.
 * ارتباط: توسط Schema و Runtime Resolver استفاده می‌شود.
 */
enum class CustomFieldType {
    TEXT,
    NUMBER,
    DATE,
    BOOLEAN
}
