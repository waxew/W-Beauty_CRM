/*
================================================
نام فایل:
jewelry_store_001.kt
وظیفه:
تعریف تنظیمات پروفایل طلا و جواهر.
منطق فروش و حسابداری داخل Module مربوطه قرار می گیرد.
================================================
*/

object JewelryStore001Profile {
    const val id = "jewelry_store_001"
    const val type = "JEWELRY_STORE"

    val modules = listOf(
        "Customer",
        "Product",
        "Sales",
        "Invoice",
        "Reports"
    )

    val attributes = listOf(
        "Weight",
        "Purity",
        "Stone",
        "Craft Fee"
    )
}
