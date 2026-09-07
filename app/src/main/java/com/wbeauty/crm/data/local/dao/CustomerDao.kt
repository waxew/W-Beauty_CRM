package com.wbeauty.crm.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.wbeauty.crm.data.local.entity.CustomerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {
    @Query("SELECT * FROM customers")
    fun getAll(): Flow<List<CustomerEntity>>
}