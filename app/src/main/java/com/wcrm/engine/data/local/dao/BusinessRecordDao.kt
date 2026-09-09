package com.wcrm.engine.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wcrm.engine.data.local.entity.BusinessRecordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BusinessRecordDao {

    @Query("SELECT * FROM business_records WHERE profileId = :profileId AND moduleId = :moduleId ORDER BY id DESC")
    fun observe(profileId: String, moduleId: String): Flow<List<BusinessRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: BusinessRecordEntity)

    @Query("DELETE FROM business_records WHERE id = :id")
    suspend fun delete(id: Long)
}
