package com.wcrm.engine.core.customer

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/** دریافت جریان لیست مشتریان. */
class ObserveCustomersUseCase @Inject constructor(
    private val repository: CustomerRepository
) {
    operator fun invoke(): Flow<List<Customer>> = repository.observeCustomers()
}

/** جستجوی مشتریان با نام یا شماره تماس. */
class SearchCustomersUseCase @Inject constructor(
    private val repository: CustomerRepository
) {
    operator fun invoke(query: String): Flow<List<Customer>> = repository.searchCustomers(query)
}

/** افزودن مشتری جدید پس از اعتبارسنجی پایه. */
class AddCustomerUseCase @Inject constructor(
    private val repository: CustomerRepository
) {
    suspend operator fun invoke(customer: Customer): Long {
        require(customer.name.isNotBlank()) { "نام مشتری نمی‌تواند خالی باشد." }
        require(customer.phone.isNotBlank() || !customer.mobile.isNullOrBlank()) {
            "حداقل یک شماره تماس باید ثبت شود."
        }
        return repository.addCustomer(customer)
    }
}

/** ویرایش مشتری موجود. */
class UpdateCustomerUseCase @Inject constructor(
    private val repository: CustomerRepository
) {
    suspend operator fun invoke(customer: Customer) {
        require(customer.id > 0) { "شناسه مشتری برای ویرایش معتبر نیست." }
        require(customer.name.isNotBlank()) { "نام مشتری نمی‌تواند خالی باشد." }
        repository.updateCustomer(customer)
    }
}

/** حذف مشتری با شناسه. */
class DeleteCustomerUseCase @Inject constructor(
    private val repository: CustomerRepository
) {
    suspend operator fun invoke(id: Long) {
        require(id > 0) { "شناسه مشتری برای حذف معتبر نیست." }
        repository.deleteCustomer(id)
    }
}
