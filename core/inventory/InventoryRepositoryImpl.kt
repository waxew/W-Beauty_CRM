package com.wcrm.core.inventory

/**
 * پیاده سازی Repository موجودی.
 *
 * این لایه واسط بین منطق کسب و کار و منبع داده است.
 * در مرحله اتصال Data Layer، این کلاس به DAO واقعی Room متصل می شود.
 */
class InventoryRepositoryImpl(
    private val inventoryDao: InventoryDao
) : InventoryRepository {

    override suspend fun getInventory(productId: String): InventoryEntity? {
        return inventoryDao.getInventory(productId)
    }

    override suspend fun saveInventory(inventory: InventoryEntity) {
        inventoryDao.saveInventory(inventory)
    }

    override suspend fun updateQuantity(productId: String, quantity: Int) {
        inventoryDao.updateQuantity(productId, quantity)
    }

    override suspend fun getStockHistory(productId: String): List<StockMovementEntity> {
        return inventoryDao.getStockHistory(productId)
    }
}
