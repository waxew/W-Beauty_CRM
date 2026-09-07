package com.wbeauty.crm.feature.customer

/**
 * اتصال رویدادهای رابط کاربری مشتری به ViewModel.
 * این لایه برای جلوگیری از اتصال مستقیم UI به منطق داده استفاده می‌شود.
 */
class CustomerEventHandler(
    private val onSave: (String, String) -> Unit
) {
    fun handle(event: CustomerEvent) {
        when (event) {
            is CustomerEvent.Save -> onSave(event.name, event.phone)
        }
    }
}
