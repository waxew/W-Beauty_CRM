package core.inventory

/**
 * وضعیت قابل مصرف توسط لایه UI ماژول Inventory
 * این مدل باعث جداسازی UI از Backend و Repository می‌شود.
 */
data class InventoryUiState(
    val isLoading: Boolean = false,
    val items: List<InventoryEntity> = emptyList(),
    val errorMessage: String? = null
)
