/*
================================================
نام فایل:
StoreBusinessCatalog.kt

وظیفه:
ثبت شناسه‌های Business Profile فروشگاهی.

ارتباط:
برای انتخاب Profile و اعتبارسنجی استفاده می‌شود.

نکات توسعه:
این فایل فقط Catalog است و نباید شامل Workflow باشد.
منطق هر Module باید در Core قرار گیرد.
================================================
*/

package com.wbeauty.crm.business_profile

object StoreBusinessCatalog {

    val supportedProfiles = listOf(
        "mobile_store_001",
        "boutique_store_001",
        "cosmetics_store_001",
        "home_appliance_store_001",
        "auto_parts_store_001",
        "jewelry_store_001",
        "book_store_001",
        "grocery_store_001",
        "pet_store_001",
        "omnichannel_store_001"
    )
}
