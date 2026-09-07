package com.wbeauty.crm.core.customer.domain.repository

import com.wbeauty.crm.core.customer.domain.model.Customer

/**
 * قرارداد دسترسی به مشتریان در CRM Core.
 * پیاده سازی دیتابیس در لایه Data قرار می گیرد.
 */
interface CustomerRepository {
    suspend fun getCustomers(): List<Customer>
    suspend fun saveCustomer(customer: Customer)
}
