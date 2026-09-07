package com.wcrm.engine.data.local

import com.wcrm.engine.domain.customer.Customer

/**
 * Local storage abstraction placeholder.
 *
 * Database implementation will be connected in the persistence phase.
 */
interface CustomerLocalDataSource {
    suspend fun loadCustomers(): List<Customer>
    suspend fun saveCustomer(customer: Customer)
}
