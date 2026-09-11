package core.inventory

/**
 * هماهنگ کننده جریان کامل موجودی بین UI و ViewModel
 *
 * این لایه نقطه اتصال Event های رابط کاربری با مدیریت State است.
 */
class InventoryFlowCoordinator(
    private val viewModel: InventoryViewModel
) {

    fun dispatch(event: InventoryUiEvent) {
        viewModel.handle(event)
    }
}
