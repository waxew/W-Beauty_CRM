package com.wbeauty.crm.business_profile

/*
================================================
نام فایل:
AttributeSchemaRegistry.kt

وظیفه:
مدیریت Schema های متغیر هر کسب و کار.

ارتباط:
Business Profile تعیین می‌کند برای هر Entity چه Attribute هایی فعال باشند.

نکات توسعه:
فیلدهای اختصاصی مانند IMEI، Skin Type، Blood Type و Size نباید داخل Entity های Core قرار بگیرند.
================================================
*/

object AttributeSchemaRegistry {
    private var schemas: List<AttributeSchema> = emptyList()

    fun initialize(attributeSchemas: List<AttributeSchema>) {
        schemas = attributeSchemas
    }

    fun getSchemas(): List<AttributeSchema> {
        return schemas
    }

    fun getEntitySchemas(entityName: String): List<AttributeSchema> {
        return schemas.filter { it.entityName == entityName }
    }
}
