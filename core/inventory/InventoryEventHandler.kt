package core.inventory

/**
 * قرارداد پردازش رویدادهای UI ماژول Inventory
 *
 * UI فقط Event ارسال می‌کند و ViewModel مسئول اجرای منطق است.
 */
interface InventoryEventHandler {
    fun handle(event: InventoryUiEvent)
}
