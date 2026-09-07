package com.wbeauty.crm.data.repository

import com.wbeauty.crm.data.local.entity.CustomerEntity
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {
    fun getCustomers(): Flow<List<CustomerEntity>>
    suspend fun insert(customer: CustomerEntity)
}
