package core.inventory

/**
 * Contract placeholder for Inventory Compose screen.
 *
 * This layer will connect InventoryViewModel state and UI actions.
 * UI implementation remains separated from business logic.
 */
interface InventoryScreen {
    fun onRefresh()
    fun onAddStock()
    fun onRemoveStock()
}
