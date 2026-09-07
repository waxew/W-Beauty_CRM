/*
================================================
نام فایل:
BusinessRuntimeState.kt

وظیفه:
مدل وضعیت نهایی Business Runtime

ارتباط:
نتیجه اجرای Resolver و Runtime Builder است.

نکات توسعه:
این کلاس فقط وضعیت اجرا را نگهداری می‌کند و منطق صنعت داخل آن قرار نمی‌گیرد.
================================================
*/

package com.wbeauty.crm.business_profile.runtime

/**
 * وضعیت فعال یک نمونه CRM.
 */
data class BusinessRuntimeState(
    val businessId: String,
    val modules: List<String>,
    val schemas: List<String>
)
