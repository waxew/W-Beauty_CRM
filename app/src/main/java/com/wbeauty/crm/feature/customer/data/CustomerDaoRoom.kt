package com.wbeauty.crm.feature.customer.data

/**
 * رابط دسترسی به اطلاعات مشتری در Room
 */
@Dao
interface CustomerDaoRoom {

    @Query("SELECT * FROM customers ORDER BY createdAt DESC")
    fun getCustomers(): Flow<List<CustomerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(customer: CustomerEntity)

    @Update
    suspend fun update(customer: CustomerEntity)

    @Delete
    suspend fun delete(customer: CustomerEntity)
}
