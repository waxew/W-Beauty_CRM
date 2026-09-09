package com.wcrm.engine.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * جدول عمومی داده برای تمام Business Profileها.
 */
@Entity(tableName = "business_records")
data class BusinessRecordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val profileId: String,
    val moduleId: String,
    val title: String,
    val payloadJson: String,
    val createdAt: Long
)
