package core.inventory

/**
 * کنترل وضعیت بین ViewModel و UI ماژول Inventory.
 *
 * این لایه برای نگهداری State فعلی و آماده‌سازی اتصال Compose استفاده می‌شود.
 */
class InventoryStateController {

    private var state: InventoryUiState = InventoryUiState()

    fun currentState(): InventoryUiState {
        return state
    }

    fun updateState(newState: InventoryUiState) {
        state = newState
    }

    fun setLoading(loading: Boolean) {
        state = state.copy(isLoading = loading)
    }
}
