/*
================================================
نام فایل:
omnichannel_store_001.kt
وظیفه:
تعریف تنظیمات فروشگاه آنلاین و حضوری.
================================================
*/

object OmnichannelStore001Profile {
    const val id = "omnichannel_store_001"
    const val type = "OMNICHANNEL_STORE"

    val modules = listOf(
        "Online Order",
        "Delivery",
        "Inventory Sync",
        "Customer CRM",
        "Payment"
    )

    val attributes = listOf(
        "Channel",
        "Customer Source",
        "Order Type",
        "Delivery Type"
    )
}
