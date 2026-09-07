/*
================================================
نام فایل:
BusinessProfileRuntimeResolver.kt

وظیفه:
انتخاب و آماده‌سازی Business Profile فعال در زمان اجرای برنامه.

ارتباط:
این فایل بین BusinessRegistry، Module Registry و Schema Engine قرار می‌گیرد.

نکات توسعه:
هیچ منطق اختصاصی صنعت نباید در این فایل قرار گیرد.
Core فقط Profile فعال را دریافت می‌کند.
================================================
*/

package business_profile.runtime

import business_profile.BusinessProfile

/**
 * Resolver عمومی برای تبدیل businessId به Profile فعال.
 */
class BusinessProfileRuntimeResolver(
    private val profiles: Map<String, BusinessProfile>
) {

    fun resolve(businessId: String): BusinessProfile? {
        return profiles[businessId]
    }
}
