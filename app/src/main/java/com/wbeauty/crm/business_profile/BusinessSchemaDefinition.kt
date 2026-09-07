package com.wbeauty.crm.business_profile

/*
================================================
نام فایل:
BusinessSchemaDefinition.kt

وظیفه:
تعریف Schema های پویا برای اطلاعات اختصاصی هر صنعت.

ارتباط:
Business Profile تعیین می‌کند هر Entity چه Attribute Schema هایی داشته باشد.

نکات توسعه:
فیلدهای اختصاصی مانند IMEI، Skin Type و Blood Type نباید داخل Entity Core قرار بگیرند.
================================================
*/

data class BusinessSchemaDefinition(
    val entityName: String,
    val schemas: List<AttributeSchema>
)
