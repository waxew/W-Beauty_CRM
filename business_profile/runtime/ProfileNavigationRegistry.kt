package com.wcrm.engine.businessprofile.runtime

/**
 * رجیستری مسیرهای قابل نمایش بر اساس Business Profile.
 *
 * این لایه فقط مسئول نگهداری Navigation metadata است.
 * UI نهایی در لایه Compose بر اساس این اطلاعات ساخته می‌شود.
 */
object ProfileNavigationRegistry {

    fun modulesFor(profileId: String): List<String> {
        return when (profileId) {
            "mobile_store_001" -> listOf("Customer", "Product", "Inventory", "Sales", "Invoice")
            "boutique_store_001" -> listOf("Customer", "Product", "Inventory", "Sales", "Invoice")
            else -> listOf("Customer", "Product")
        }
    }
}
