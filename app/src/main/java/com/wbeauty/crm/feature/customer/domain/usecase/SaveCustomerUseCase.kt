package com.wbeauty.crm.feature.customer.domain.usecase

import com.wbeauty.crm.feature.customer.domain.Customer
import com.wbeauty.crm.feature.customer.domain.CustomerRepository

/**
 * ثبت مشتری جدید در سیستم CRM
 * این کلاس منطق ذخیره مشتری را از رابط کاربری جدا می‌کند.
 */
class SaveCustomerUseCase(
    private val repository: CustomerRepository
) {
    suspend operator fun invoke(customer: Customer): Boolean {
        return repository.saveCustomer(customer)
    }
}
