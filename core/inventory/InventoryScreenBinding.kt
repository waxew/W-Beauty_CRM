package core.inventory

/**
 * اتصال لایه UI ماژول Inventory به جریان داده.
 *
 * این کلاس قرارداد اتصال Screen به State و Event را مشخص می‌کند
 * تا Compose UI مستقل از Backend باقی بماند.
 */
class InventoryScreenBinding {
    fun bind(state: InventoryUiState): InventoryUiState {
        return state
    }

    fun dispatch(event: InventoryUiEvent): InventoryUiEvent {
        return event
    }
}
