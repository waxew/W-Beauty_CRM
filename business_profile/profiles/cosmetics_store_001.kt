/*
نام فایل: cosmetics_store_001.kt
وظیفه: تعریف تنظیمات فروشگاه آرایشی
ارتباط: Profile configuration
نکات توسعه: بدون منطق تجاری
*/
object CosmeticsStore001Profile {
    val id = "cosmetics_store_001"
    val type = "COSMETICS_STORE"
    val modules = listOf("Customer","Product","Inventory","Sales","Invoice")
    val attributes = listOf("Volume","Brand","Skin Type","Batch Number")
}
