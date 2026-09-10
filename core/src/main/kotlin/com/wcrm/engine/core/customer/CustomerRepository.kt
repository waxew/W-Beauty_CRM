package com.wcrm.engine.core.customer

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/** قرارداد دامنه برای مدیریت مشتریان. */
interface CustomerRepository {
    fun observeCustomers(): Flow<List<Customer>>
    fun searchCustomers(query: String): Flow<List<Customer>>
    suspend fun getCustomer(id: Long): Customer?
    suspend fun addCustomer(customer: Customer): Long
    suspend fun updateCustomer(customer: Customer)
    suspend fun deleteCustomer(id: Long)
}

/** پیاده‌سازی واقعی Repository روی Room. */
@Singleton
class CustomerRepositoryImpl @Inject constructor(
    private val dao: CustomerDao
) : CustomerRepository {

    override fun observeCustomers(): Flow<List<Customer>> =
        dao.observeAll().map { list -> list.map(CustomerEntity::toDomain) }

    override fun searchCustomers(query: String): Flow<List<Customer>> =
        dao.search(query.trim()).map { list -> list.map(CustomerEntity::toDomain) }

    override suspend fun getCustomer(id: Long): Customer? = dao.getById(id)?.toDomain()

    override suspend fun addCustomer(customer: Customer): Long = dao.insert(customer.toEntity())

    override suspend fun updateCustomer(customer: Customer) {
        dao.update(customer.copy(updatedAt = System.currentTimeMillis()).toEntity())
    }

    override suspend fun deleteCustomer(id: Long) {
        dao.deleteById(id)
    }
}
