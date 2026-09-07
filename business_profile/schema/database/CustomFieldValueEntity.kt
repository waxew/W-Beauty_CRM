/*
================================================
نام فایل:
CustomFieldValueEntity.kt
وظیفه:
ذخیره مقدار Attributeهای پویا برای Entityهای سیستم.

ارتباط:
Customer Core / Product Core / Custom Field Engine

نکات توسعه:
این جدول جایگزین اضافه کردن Field ثابت برای هر صنعت است.
================================================
*/

package com.wbeauty.crm.business_profile.schema.database

/**
 * مقدار ثبت شده یک فیلد سفارشی.
 */
data class CustomFieldValueEntity(
    val id: Long,
    val entityId: String,
    val entityType: String,
    val fieldKey: String,
    val value: String
)
