package com.wcrm.engine.data.repository

import com.wcrm.engine.domain.customer.Customer
import com.wcrm.engine.domain.customer.CustomerRepository

/**
 * Default data implementation for Customer repository.
 *
 * This layer will later connect to local database and remote data sources.
 */
class CustomerRepositoryImpl : CustomerRepository {

    private val items = mutableListOf<Customer>()

    override fun save(customer: Customer) {
        items.removeIf { it.id == customer.id }
        items.add(customer)
    }

    override fun findById(id: String): Customer? {
        return items.firstOrNull { it.id == id }
    }

    suspend fun getCustomers(): List<Customer> {
        return items.toList()
    }

    suspend fun saveCustomer(customer: Customer) {
        save(customer)
    }
}
