/*
================================================
نام فایل:
CustomFieldDao.kt

وظیفه:
تعریف لایه دسترسی داده برای Custom Field Engine.

ارتباط:
Database Layer <-> Custom Field Repository

نکات توسعه:
این فایل نباید شامل منطق کسب‌وکار باشد.
فقط عملیات ذخیره و بازیابی داده‌های پویا انجام می‌شود.
================================================
*/

package com.wbeauty.crm.business_profile.schema.database

interface CustomFieldDao {
    fun insertDefinition(definition: CustomFieldDefinitionEntity)
    fun insertValue(value: CustomFieldValueEntity)
    fun getValues(entityId: String, entityType: String): List<CustomFieldValueEntity>
}
