package com.wcrm.engine.domain.business

import com.wcrm.engine.data.entity.BusinessRecordEntity
import kotlinx.coroutines.flow.Flow

/**
 * قرارداد لایه Domain برای داده های Profile محور.
 */
interface BusinessRecordRepository {
    fun observe(profileId: String): Flow<List<BusinessRecordEntity>>
    suspend fun save(record: BusinessRecordEntity)
    suspend fun delete(id: Long)
}
