/*
================================================
نام فایل:
BusinessRuntimeInitializer.kt
وظیفه:
راه‌اندازی Runtime مربوط به Business Profile هنگام شروع برنامه.

ارتباط:
Business ID -> Resolver -> Runtime State -> Application

نکات توسعه:
این فایل نباید شامل منطق صنعت خاص باشد.
تمام تصمیم‌ها باید از Business Profile دریافت شوند.
================================================
*/

package business_profile.runtime

class BusinessRuntimeInitializer(
    private val resolver: BusinessProfileRuntimeResolver
) {

    fun initialize(businessId: String): BusinessRuntimeState {
        return resolver.resolve(businessId)
    }
}
