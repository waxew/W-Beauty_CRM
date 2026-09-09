package com.wcrm.engine.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wcrm.engine.data.entity.BusinessRecordEntity
import kotlinx.coroutines.flow.Flow

/**
 * دسترسی محلی به رکوردهای عمومی Profileها.
 */
@Dao
interface BusinessRecordDao {

    @Query("SELECT * FROM business_records WHERE profileId = :profileId ORDER BY id DESC")
    fun observe(profileId: String): Flow<List<BusinessRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(record: BusinessRecordEntity)

    @Query("DELETE FROM business_records WHERE id = :id")
    suspend fun delete(id: Long)
}
