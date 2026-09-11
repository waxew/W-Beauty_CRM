package core.inventory

/**
 * ViewModel لایه موجودی
 *
 * این کلاس نقطه اتصال UseCase های موجودی با رابط کاربری است.
 * منطق کسب و کار در Repository و UseCase باقی می ماند
 * و UI فقط Event ارسال می کند.
 */
class InventoryViewModel(
    private val inventoryUseCases: InventoryUseCases
) : InventoryEventHandler {

    private var currentInventory: InventoryEntity? = null

    /**
     * دریافت موجودی یک محصول
     */
    fun loadInventory(productId: String): InventoryEntity? {
        currentInventory = inventoryUseCases.getInventory(productId)
        return currentInventory
    }

    /**
     * افزایش موجودی کالا
     */
    fun addStock(productId: String, quantity: Int) {
        inventoryUseCases.addStock(productId, quantity)
    }

    /**
     * کاهش موجودی کالا
     */
    fun removeStock(productId: String, quantity: Int) {
        inventoryUseCases.removeStock(productId, quantity)
    }

    /**
     * پردازش Event های UI
     */
    override fun handle(event: InventoryUiEvent) {
        when (event) {
            is InventoryUiEvent.AddStock -> addStock(event.productId, event.quantity)
            is InventoryUiEvent.RemoveStock -> removeStock(event.productId, event.quantity)
            InventoryUiEvent.Refresh -> {
                // Refresh توسط Screen یا لایه State مدیریت می‌شود
            }
        }
    }
}
