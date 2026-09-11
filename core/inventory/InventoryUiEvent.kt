package core.inventory

/**
 * UI events for Inventory feature.
 * Keeps user actions separated from business logic.
 */
sealed interface InventoryUiEvent {
    data class AddStock(val productId: String, val quantity: Int) : InventoryUiEvent
    data class RemoveStock(val productId: String, val quantity: Int) : InventoryUiEvent
    data object Refresh : InventoryUiEvent
}
