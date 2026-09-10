package com.asteam.wcrm.core.inventory

/**
 * مدل پایه موجودی کالا.
 * این مدل در لایه Core قرار دارد تا مستقل از UI و دیتابیس باشد.
 */
data class InventoryEntity(
    val id: Long = 0,
    val productId: Long,
    val quantity: Int,
    val minimumStock: Int = 0,
    val warehouseId: Long? = null,
    val updatedAt: Long = System.currentTimeMillis()
)
