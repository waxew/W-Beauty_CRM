/*
================================================
نام فایل:
grocery_store_001.kt
وظیفه:
تعریف تنظیمات پروفایل فروشگاه مواد غذایی.
================================================
*/

object GroceryStore001Profile {
    const val id = "grocery_store_001"
    const val type = "GROCERY_STORE"

    val modules = listOf(
        "Product",
        "Inventory",
        "Supplier",
        "Sales"
    )

    val attributes = listOf(
        "Expiration Date",
        "Batch Number",
        "Unit",
        "Weight"
    )
}
