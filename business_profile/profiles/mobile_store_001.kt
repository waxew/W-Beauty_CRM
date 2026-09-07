/*
نام فایل: mobile_store_001.kt
وظیفه: تعریف تنظیمات CRM موبایل فروشی
ارتباط: توسط BusinessRegistry بارگذاری می‌شود
نکات توسعه: این فایل فقط تنظیمات است و منطق ندارد.
*/
object MobileStore001Profile {
    val id = "mobile_store_001"
    val type = "MOBILE_STORE"
    val modules = listOf("Customer","Product","Inventory","Sales","Invoice","Warranty","Repair","IMEI")
    val attributes = listOf("Model","Brand","Storage","Color","Serial Number")
}
