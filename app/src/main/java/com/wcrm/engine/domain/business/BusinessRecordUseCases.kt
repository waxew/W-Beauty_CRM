package com.wcrm.engine.domain.business

import com.wcrm.engine.data.entity.BusinessRecordEntity
import kotlinx.coroutines.flow.Flow

/**
 * عملیات اصلی داده های Profile محور.
 */
class ObserveBusinessRecords(
    private val repository: BusinessRecordRepository
) {
    operator fun invoke(profileId: String): Flow<List<BusinessRecordEntity>> =
        repository.observe(profileId)
}

class SaveBusinessRecord(
    private val repository: BusinessRecordRepository
) {
    suspend operator fun invoke(record: BusinessRecordEntity) {
        repository.save(record)
    }
}

class DeleteBusinessRecord(
    private val repository: BusinessRecordRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.delete(id)
    }
}
