package com.wbeauty.crm.feature.customer

/**
 * نتیجه عملیات ذخیره مشتری.
 */
sealed class CustomerSaveResult {
    data object Idle : CustomerSaveResult()
    data object Success : CustomerSaveResult()
    data class Error(val message: String) : CustomerSaveResult()
}
