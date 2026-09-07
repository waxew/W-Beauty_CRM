/*
================================================
نام فایل:
pet_store_001.kt
وظیفه:
تعریف تنظیمات پروفایل پت شاپ.
================================================
*/

object PetStore001Profile {
    const val id = "pet_store_001"
    const val type = "PET_STORE"

    val modules = listOf(
        "Customer",
        "Product",
        "Inventory",
        "Sales"
    )

    val attributes = listOf(
        "Animal Type",
        "Age",
        "Weight",
        "Food Type",
        "Expiration Date"
    )
}
