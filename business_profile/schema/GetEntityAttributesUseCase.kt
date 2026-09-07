package com.wbeauty.crm.business_profile.schema

/*
================================================
نام فایل:
GetEntityAttributesUseCase.kt
وظیفه:
دریافت Attributeهای یک Entity
ارتباط:
Custom Field Engine -> Runtime UI
نکات توسعه:
اطلاعات پویا از Core Entity جدا باقی می‌ماند.
================================================
*/

class GetEntityAttributesUseCase(
    private val repository: CustomFieldRepository
) {
    suspend fun execute(entityId: String, entityType: String): List<CustomFieldValue> {
        return repository.getValues(entityId, entityType)
    }
}
