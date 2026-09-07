/*
================================================
نام فایل:
ActiveSchemaConfiguration.kt

وظیفه:
نگهداری Schema های فعال برای Business Runtime

ارتباط:
توسط Runtime Builder استفاده می‌شود.

نکات توسعه:
هیچ Attribute اختصاصی کسب‌وکار نباید داخل Core Entity قرار بگیرد.
تمام اطلاعات متغیر باید از Schema Engine عبور کند.
================================================
*/

package com.wbeauty.crm.business_profile.runtime

/**
 * تنظیمات Schema های فعال در نسخه جاری CRM.
 */
data class ActiveSchemaConfiguration(
    val schemas: List<String>
)
