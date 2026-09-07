/*
================================================
نام فایل:
StoreIndustryType.kt

وظیفه:
تعریف انواع کسب و کارهای فروشگاهی در Business Profile.

ارتباط:
توسط Business Profile و Registry استفاده می‌شود.

نکات توسعه:
هیچ منطق فروشگاهی نباید در این فایل قرار گیرد.
این فایل فقط شناسه صنعت را نگهداری می‌کند.
================================================
*/

package com.wbeauty.crm.business_profile

/**
 * انواع کسب و کارهای فروشگاهی.
 */
enum class StoreIndustryType {
    MOBILE_STORE,
    BOUTIQUE,
    COSMETICS_STORE,
    HOME_APPLIANCE_STORE,
    AUTO_PARTS_STORE,
    JEWELRY_STORE,
    BOOK_STORE,
    GROCERY_STORE,
    PET_STORE,
    OMNICHANNEL_STORE
}
