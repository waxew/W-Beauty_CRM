/*
نام فایل: boutique_store_001.kt
وظیفه: تعریف تنظیمات CRM بوتیک
ارتباط: توسط BusinessRegistry استفاده می‌شود
نکات توسعه: فقط Profile است.
*/
object BoutiqueStore001Profile {
    val id = "boutique_store_001"
    val type = "BOUTIQUE"
    val modules = listOf("Customer","Product","Inventory","Sales","Invoice")
    val attributes = listOf("Size","Color","Material","Season","Gender","Brand")
}
