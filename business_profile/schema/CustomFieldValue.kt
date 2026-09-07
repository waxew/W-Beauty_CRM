/*
================================================
نام فایل:
CustomFieldValue.kt
وظیفه:
ذخیره مقدار Attribute های پویا
ارتباط:
CustomFieldDefinition + Core Entities
نکات توسعه:
اطلاعاتی مانند Skin Type، IMEI، Size و Blood Type
نباید به صورت Field ثابت در Core ذخیره شوند.
================================================
*/

package business_profile.schema

/**
 * مقدار ثبت شده برای یک Custom Field.
 */
data class CustomFieldValue(
    val entityId: String,
    val entityType: String,
    val fieldKey: String,
    val value: String
)
