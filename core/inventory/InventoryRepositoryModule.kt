package com.wcrm.core.inventory

/**
 * Inventory dependency wiring plan.
 *
 * Keeps inventory data access registration separated from business logic.
 * Final DI binding will connect InventoryRepository implementation to the app graph.
 */
object InventoryRepositoryModule {
    const val MODULE_NAME = "inventory"
    const val REPOSITORY_BINDING = "InventoryRepository -> InventoryRepositoryImpl"
}
