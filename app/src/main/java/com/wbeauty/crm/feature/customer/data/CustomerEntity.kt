package com.wbeauty.crm.feature.customer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * مدل واقعی مشتری برای ذخیره در Room Database.
 * اطلاعات پایه CRM سالن در این Entity نگهداری می‌شود.
 */
@Entity(tableName = "customers")
data class CustomerEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val birthday: String? = null,
    val instagram: String? = null,
    val address: String? = null,
    val notes: String? = null,
    val totalVisit: Int = 0,
    val totalPurchase: Double = 0.0,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
