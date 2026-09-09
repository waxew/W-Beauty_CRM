package com.wcrm.engine.domain.businessrecord

import kotlinx.coroutines.flow.Flow

/**
 * قرارداد Repository عمومی برای ماژول های Profile محور.
 */
interface BusinessRecordRepository {
    fun observe(profileId: String, moduleId: String): Flow<List<BusinessRecord>>
    suspend fun save(record: BusinessRecord)
    suspend fun delete(id: Long)
}
