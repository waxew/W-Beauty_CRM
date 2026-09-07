/*
================================================
نام فایل:
CustomFieldDefinition.kt
وظیفه:
تعریف ساختار فیلدهای پویا در Business Profile
ارتباط:
Business Profile + Custom Field Engine
نکات توسعه:
هیچ فیلد اختصاصی صنعت نباید داخل Core Entity قرار بگیرد.
این مدل فقط تعریف Schema است.
================================================
*/

package business_profile.schema

/**
 * تعریف یک Attribute پویا برای Entity ها.
 */
data class CustomFieldDefinition(
    val key: String,
    val label: String,
    val entityType: String,
    val dataType: String,
    val required: Boolean = false
)
