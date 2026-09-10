package com.asteam.wcrm.core.inventory

/**
 * لایه قرارداد دسترسی به داده‌های موجودی
 *
 * این Interface در مرحله بعد به Room DAO واقعی متصل می‌شود.
 * هدف: جدا نگه داشتن Domain از Database Implementation
 */
interface InventoryDao {
    fun getInventoryByProductId(productId: Long): InventoryEntity?

    fun saveInventory(inventory: InventoryEntity)

    fun updateQuantity(productId: Long, quantity: Int)
}
