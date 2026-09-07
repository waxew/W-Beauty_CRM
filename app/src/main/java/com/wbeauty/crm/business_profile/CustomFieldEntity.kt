package com.wbeauty.crm.business_profile

/**
 * وظیفه فایل:
 * مدل ذخیره مقدار Attribute های سفارشی.
 *
 * ارتباط:
 * Entity های Core از این مدل برای نگهداری داده های Industry Specific استفاده می کنند.
 *
 * نکات توسعه:
 * هیچ Industry نباید Field اختصاصی خود را داخل Core Entity اضافه کند.
 */
data class CustomFieldEntity(
    val entityId: String,
    val entityType: String,
    val schemaKey: String,
    val value: String
)
