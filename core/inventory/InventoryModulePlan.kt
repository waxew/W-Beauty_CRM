package com.asteam.wcrm.core.inventory

/**
 * نقشه اولیه ماژول انبار.
 *
 * این فایل فقط قرارداد توسعه ماژول Inventory را مشخص می‌کند.
 * پیاده سازی Entity/DAO/Repository در مراحل بعدی اضافه خواهد شد.
 */
object InventoryModulePlan {
    val components = listOf(
        "InventoryEntity",
        "StockMovementEntity",
        "InventoryDao",
        "InventoryRepository",
        "InventoryUseCase"
    )
}
