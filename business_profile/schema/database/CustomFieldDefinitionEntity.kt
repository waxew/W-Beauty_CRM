/*
================================================
نام فایل:
CustomFieldDefinitionEntity.kt
وظیفه:
تعریف Entity برای نگهداری Schema فیلدهای سفارشی.

ارتباط:
Business Profile + Custom Field Engine + Database

نکات توسعه:
این Entity نباید شامل فیلدهای اختصاصی یک صنعت باشد.
اطلاعات صنعت‌ها باید از طریق Schema ذخیره شوند.
================================================
*/

package com.wbeauty.crm.business_profile.schema.database

/**
 * تعریف یک Attribute پویا برای Entityهای مختلف.
 */
data class CustomFieldDefinitionEntity(
    val id: Long,
    val entityType: String,
    val fieldKey: String,
    val label: String,
    val dataType: String,
    val required: Boolean
)
