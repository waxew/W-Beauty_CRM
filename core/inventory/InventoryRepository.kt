package com.asteam.wcrm.core.inventory

/**
 * لایه Repository موجودی
 *
 * این قرارداد بین Domain و Data Layer قرار می‌گیرد
 * تا Core به دیتابیس یا UI وابسته نباشد.
 */
interface InventoryRepository {

    suspend fun getInventory(productId: Long): InventoryEntity?

    suspend fun saveInventory(inventory: InventoryEntity)

    suspend fun updateQuantity(
        productId: Long,
        quantity: Int
    )

    suspend fun getStockHistory(
        productId: Long
    ): List<StockMovementEntity>
}
