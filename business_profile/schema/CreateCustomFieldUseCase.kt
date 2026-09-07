package com.wbeauty.crm.business_profile.schema

/*
================================================
نام فایل:
CreateCustomFieldUseCase.kt
وظیفه:
ایجاد Attribute Schema جدید برای Entityها
ارتباط:
Custom Field Engine -> Repository
نکات توسعه:
این فایل نباید شامل منطق صنعت خاص باشد.
================================================
*/

class CreateCustomFieldUseCase(
    private val repository: CustomFieldRepository
) {
    suspend fun execute(definition: CustomFieldDefinition) {
        repository.saveDefinition(definition)
    }
}
