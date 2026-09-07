/*
================================================
نام فایل:
CustomFieldRuntimeEngine.kt

وظیفه:
مدیریت Attribute Schema های پویا در Runtime.

ارتباط:
Business Profile مشخص می‌کند چه Schema هایی فعال باشند.
Core Entity ها نباید Field اختصاصی صنعت داشته باشند.

نکات توسعه:
اطلاعاتی مانند IMEI، Size، Skin Type و Medical Notes
نباید به Entity اصلی اضافه شوند و باید از این مسیر مدیریت شوند.
================================================
*/

package business_profile.schema

class CustomFieldRuntimeEngine {

    private val schemas = mutableMapOf<String, List<String>>()

    fun registerSchema(
        entity: String,
        attributes: List<String>
    ) {
        schemas[entity] = attributes
    }

    fun getSchemas(entity: String): List<String> {
        return schemas[entity].orEmpty()
    }
}
