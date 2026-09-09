package com.wcrm.engine.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * موجودیت عمومی داده کسب و کار.
 *
 * داده های اختصاصی هر Profile داخل payloadJson ذخیره می شوند تا Core وابسته به صنف نباشد.
 */
@Entity(tableName = "business_records")
data class BusinessRecordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val profileId: String,
    val recordType: String,
    val payloadJson: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
