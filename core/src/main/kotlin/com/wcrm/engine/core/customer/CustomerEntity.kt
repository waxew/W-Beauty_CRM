package com.wcrm.engine.core.customer

import androidx.room.Entity
import androidx.room.PrimaryKey

/** موجودیت پایگاه‌داده مشتری. */
@Entity(tableName = "customers")
data class CustomerEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val phone: String,
    val mobile: String?,
    val address: String?,
    val email: String?,
    val notes: String?,
    val createdAt: Long,
    val updatedAt: Long
)

internal fun CustomerEntity.toDomain(): Customer = Customer(
    id = id,
    name = name,
    phone = phone,
    mobile = mobile,
    address = address,
    email = email,
    notes = notes,
    createdAt = createdAt,
    updatedAt = updatedAt
)

internal fun Customer.toEntity(): CustomerEntity = CustomerEntity(
    id = id,
    name = name,
    phone = phone,
    mobile = mobile,
    address = address,
    email = email,
    notes = notes,
    createdAt = createdAt,
    updatedAt = updatedAt
)
