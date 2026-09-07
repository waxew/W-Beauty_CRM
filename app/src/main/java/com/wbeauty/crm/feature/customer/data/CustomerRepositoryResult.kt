package com.wbeauty.crm.feature.customer.data

/**
 * نتیجه عملیات Repository مشتری.
 *
 * برای جلوگیری از پخش شدن خطاها در لایه های مختلف استفاده می‌شود.
 */
sealed class CustomerRepositoryResult<out T> {
    data class Success<T>(val data: T): CustomerRepositoryResult<T>()
    data class Error(val message: String): CustomerRepositoryResult<Nothing>()
    data object Loading: CustomerRepositoryResult<Nothing>()
}
