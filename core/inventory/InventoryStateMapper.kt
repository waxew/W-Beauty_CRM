package core.inventory

/**
 * Mapper layer between Inventory domain state and UI state.
 * Keeps presentation independent from backend implementation.
 */
object InventoryStateMapper {
    fun mapToUiState(
        inventoryItems: List<InventoryEntity>,
        loading: Boolean = false,
        errorMessage: String? = null
    ): InventoryUiState {
        return InventoryUiState(
            isLoading = loading,
            items = inventoryItems,
            errorMessage = errorMessage
        )
    }
}
