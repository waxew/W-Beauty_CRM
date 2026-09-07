/*
================================================
نام فایل:
home_appliance_store_001.kt
وظیفه:
تعریف تنظیمات پروفایل فروشگاه لوازم خانگی.
این فایل فقط پیکربندی Business Profile است.
منطق برنامه باید داخل Core و Module قرار گیرد.
================================================
*/

object HomeApplianceStore001Profile {
    const val id = "home_appliance_store_001"
    const val type = "HOME_APPLIANCE_STORE"

    val modules = listOf(
        "Customer",
        "Product",
        "Inventory",
        "Sales",
        "Warranty",
        "Delivery"
    )

    val attributes = listOf(
        "Model",
        "Serial Number",
        "Energy Rating"
    )
}
