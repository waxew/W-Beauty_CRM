package com.wbeauty.crm.feature.customer.domain

// قرارداد دسترسی به اطلاعات مشتریان
interface CustomerRepository {
    fun getCustomers(): List<Customer>
}

data class Customer(
    val id: Long,
    val name: String
)
