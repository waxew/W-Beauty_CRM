package com.wbeauty.crm.business_profile.schema

/*
================================================
نام فایل:
UpdateCustomFieldUseCase.kt
وظیفه:
به‌روزرسانی مقدار Attributeهای پویا
ارتباط:
Custom Field Engine -> Repository
نکات توسعه:
بدون وابستگی به نوع کسب‌وکار طراحی شود.
================================================
*/

class UpdateCustomFieldUseCase(
    private val repository: CustomFieldRepository
) {
    suspend fun execute(value: CustomFieldValue) {
        repository.saveValue(value)
    }
}
