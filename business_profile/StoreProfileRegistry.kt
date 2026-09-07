/*
================================================
نام فایل:
StoreProfileRegistry.kt

وظیفه:
ثبت پروفایل های فروشگاهی قابل استفاده در Runtime.

ارتباط:
BusinessProfileResolver از این Registry برای پیدا کردن Profile فعال استفاده می کند.

نکات توسعه:
این فایل نباید شامل منطق کسب و کار باشد.
تنها وظیفه آن نگهداری Catalog و Mapping است.
================================================
*/

package business_profile

object StoreProfileRegistry {
    private val profiles = mapOf(
        "mobile_store_001" to "MOBILE_STORE",
        "boutique_store_001" to "BOUTIQUE",
        "cosmetics_store_001" to "COSMETICS_STORE",
        "home_appliance_store_001" to "HOME_APPLIANCE_STORE",
        "auto_parts_store_001" to "AUTO_PARTS_STORE",
        "jewelry_store_001" to "JEWELRY_STORE",
        "book_store_001" to "BOOK_STORE",
        "grocery_store_001" to "GROCERY_STORE",
        "pet_store_001" to "PET_STORE",
        "omnichannel_store_001" to "OMNICHANNEL_STORE"
    )

    fun exists(id: String): Boolean = profiles.containsKey(id)

    fun getType(id: String): String? = profiles[id]
}
