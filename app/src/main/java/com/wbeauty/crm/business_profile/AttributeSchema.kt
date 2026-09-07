package com.wbeauty.crm.business_profile

/**
 * وظیفه فایل:
 * تعریف Attribute های متغیر کسب و کار.
 *
 * ارتباط:
 * BusinessProfile برای هر Entity مشخص می کند چه Attribute Schema هایی فعال شوند.
 *
 * نکات توسعه:
 * این اطلاعات نباید به صورت Field ثابت داخل Entity های Core قرار گیرند.
 * مثال: SkinType، BloodType، IMEI و Size باید Schema باشند.
 */
data class AttributeSchema(
    val entityName: String,
    val key: String,
    val label: String,
    val dataType: AttributeDataType,
    val required: Boolean = false
)

enum class AttributeDataType {
    TEXT,
    NUMBER,
    DATE,
    BOOLEAN,
    SELECT
}
