package com.wcrm.engine.core.product

import androidx.room.Entity
import androidx.room.PrimaryKey

/** موجودیت پایدار محصول در Room. */
@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val category: String?,
    val brand: String?,
    val price: Long,
    val cost: Long,
    val stock: Int,
    val createdAt: Long,
    val updatedAt: Long
)

internal fun ProductEntity.toDomain(): Product = Product(
    id = id,
    name = name,
    category = category,
    brand = brand,
    price = price,
    cost = cost,
    stock = stock,
    createdAt = createdAt,
    updatedAt = updatedAt
)

internal fun Product.toEntity(): ProductEntity = ProductEntity(
    id = id,
    name = name,
    category = category,
    brand = brand,
    price = price,
    cost = cost,
    stock = stock,
    createdAt = createdAt,
    updatedAt = updatedAt
)
