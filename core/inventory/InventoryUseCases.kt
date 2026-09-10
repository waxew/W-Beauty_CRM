package com.wcrm.core.inventory

/**
 * قراردادهای لایه کاربردی موجودی.
 * این کلاس‌ها منطق کسب‌وکار را از UI و Data Layer جدا نگه می‌دارند.
 */

interface GetInventory {
    suspend operator fun invoke(productId: String): InventoryEntity?
}

interface AddStock {
    suspend operator fun invoke(productId: String, quantity: Int): Result<Unit>
}

interface RemoveStock {
    suspend operator fun invoke(productId: String, quantity: Int): Result<Unit>
}

interface GetStockHistory {
    suspend operator fun invoke(productId: String): List<StockMovementEntity>
}
