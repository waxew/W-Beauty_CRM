/*
================================================
نام فایل:
DefaultBusinessSelector.kt
وظیفه:
انتخاب Business Profile پیش فرض برای اجرای برنامه.

ارتباط:
Application Startup -> Business ID -> Runtime Initializer

نکات توسعه:
در آینده می‌تواند از تنظیمات کاربر، سرور یا License دریافت شود.
================================================
*/

package business_profile.runtime

class DefaultBusinessSelector {

    fun getDefaultBusinessId(): String {
        return "beauty_center_001"
    }
}
