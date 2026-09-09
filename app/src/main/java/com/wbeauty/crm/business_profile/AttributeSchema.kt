package com.wbeauty.crm.business_profile

/**
 * تعریف Attribute پویا برای اطلاعات اختصاصی هر کسب و کار.
 *
 * فیلدهای اختصاصی مثل IMEI، رنگ، سایز و موارد صنعتی
 * نباید داخل Entity های Core قرار بگیرند.
 */
data class AttributeSchema(
    val entityName: String,
    val key: String,
    val label: String,
    val type: String
)
