/*
================================================
نام فایل:
CustomFieldRepository.kt

وظیفه:
لایه Repository برای مدیریت Attributeهای پویا.

ارتباط:
Domain Layer <-> Database DAO

نکات توسعه:
ماژول‌های مختلف مانند CRM، فروشگاه و کلینیک
نباید مستقیم با Database کار کنند.
از این Repository استفاده می‌کنند.
================================================
*/

package com.wbeauty.crm.business_profile.schema

import com.wbeauty.crm.business_profile.schema.database.CustomFieldValueEntity

interface CustomFieldRepository {
    fun save(value: CustomFieldValueEntity)
    fun get(entityId: String, entityType: String): List<CustomFieldValueEntity>
}
