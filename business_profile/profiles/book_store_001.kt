/*
================================================
نام فایل:
book_store_001.kt
وظیفه:
تعریف تنظیمات پروفایل کتاب فروشی.
================================================
*/

object BookStore001Profile {
    const val id = "book_store_001"
    const val type = "BOOK_STORE"

    val modules = listOf(
        "Customer",
        "Product",
        "Inventory",
        "Sales",
        "Invoice"
    )

    val attributes = listOf(
        "Author",
        "Publisher",
        "ISBN",
        "Edition",
        "Category"
    )
}
