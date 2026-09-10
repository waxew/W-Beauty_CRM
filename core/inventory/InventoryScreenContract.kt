package core.inventory

/**
 * قرارداد ارتباط لایه UI با ماژول Inventory.
 * این لایه فقط ساختار مورد نیاز Screen را تعریف می‌کند.
 */
interface InventoryScreenContract {
    fun onRefresh()
    fun onAddStock(productId: Long, quantity: Int)
    fun onRemoveStock(productId: Long, quantity: Int)
}
