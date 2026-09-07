package com.wbeauty.crm.feature.customer.presentation

/**
 * رویدادهای صفحه مشتری
 * تمام تعاملات کاربر از این مسیر به ViewModel ارسال می‌شوند.
 */
sealed class CustomerAction {
    data class Search(val query: String) : CustomerAction()
    data class Delete(val id: Long) : CustomerAction()
    data object Refresh : CustomerAction()
}
