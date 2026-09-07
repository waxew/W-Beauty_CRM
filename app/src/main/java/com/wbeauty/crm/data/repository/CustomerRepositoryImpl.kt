package com.wbeauty.crm.data.repository

import com.wbeauty.crm.data.local.dao.CustomerDao
import com.wbeauty.crm.data.local.entity.CustomerEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val dao: CustomerDao
) : CustomerRepository {

    override fun getCustomers(): Flow<List<CustomerEntity>> = dao.getCustomers()

    override suspend fun addCustomer(customer: CustomerEntity) {
        dao.insert(customer)
    }
}
