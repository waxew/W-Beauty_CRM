package com.wcrm.engine.data.repository

import com.wcrm.engine.data.entity.BusinessRecordEntity
import com.wcrm.engine.data.local.BusinessRecordDao
import com.wcrm.engine.domain.business.BusinessRecordRepository
import kotlinx.coroutines.flow.Flow

/**
 * اتصال Domain به Room.
 */
class BusinessRecordRepositoryImpl(
    private val dao: BusinessRecordDao
) : BusinessRecordRepository {

    override fun observe(profileId: String): Flow<List<BusinessRecordEntity>> =
        dao.observe(profileId)

    override suspend fun save(record: BusinessRecordEntity) {
        dao.save(record)
    }

    override suspend fun delete(id: Long) {
        dao.delete(id)
    }
}
