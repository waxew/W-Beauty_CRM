/*
================================================
نام فایل:
auto_parts_store_001.kt
وظیفه:
تعریف تنظیمات پروفایل فروشگاه قطعات خودرو.
این فایل شامل منطق کسب و کار نیست.
================================================
*/

object AutoPartsStore001Profile {
    const val id = "auto_parts_store_001"
    const val type = "AUTO_PARTS_STORE"

    val modules = listOf(
        "Customer",
        "Product",
        "Inventory",
        "Sales",
        "Supplier"
    )

    val attributes = listOf(
        "Part Number",
        "Compatible Vehicle",
        "Brand",
        "Model",
        "Year"
    )
}
