/*
================================================
نام فایل:
BusinessStartupConfiguration.kt

وظیفه:
ایجاد نقطه شروع بارگذاری تنظیمات کسب‌وکار فعال.

ارتباط:
Business Profile Runtime
Business Resolver
Module Registry
Schema Engine

نکات توسعه:
این فایل نباید شامل منطق یک صنعت خاص باشد.
تنها مسئول هماهنگی Runtime است.
================================================
*/

package com.wbeauty.crm.business_profile.runtime

/**
 * پیکربندی اولیه اجرای Business Profile.
 *
 * Core فقط از این قرارداد استفاده می‌کند و
 * جزئیات هر کسب‌وکار داخل Profile قرار می‌گیرد.
 */
data class BusinessStartupConfiguration(
    val businessId: String,
    val loadModules: Boolean = true,
    val loadSchemas: Boolean = true
)
