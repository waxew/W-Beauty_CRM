/*
================================================
نام فایل:
ProfileRuntimeContext.kt

وظیفه:
نگهداری وضعیت Profile فعال در زمان اجرای برنامه.

ارتباط:
Runtime Layer و Module Registry از این Context استفاده می کنند.

نکات توسعه:
اطلاعات صنعت نباید در Core Entity ها قرار گیرد.
================================================
*/

package business_profile

 data class ProfileRuntimeContext(
    val businessId: String,
    val industryType: String,
    val enabledModules: List<String>,
    val enabledSchemas: List<String>
)
