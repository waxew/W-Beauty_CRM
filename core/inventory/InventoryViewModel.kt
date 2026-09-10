package core.inventory

/**
 * ViewModel لایه موجودی
 *
 * این کلاس نقطه اتصال UseCase های موجودی با رابط کاربری است.
 * منطق کسب و کار در Repository و UseCase باقی می ماند
 * و UI فقط وضعیت مورد نیاز خود را دریافت می کند.
 */
class InventoryViewModel(
    private val inventoryUseCases: InventoryUseCases
) {

    // وضعیت فعلی موجودی برای نمایش در UI
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
}