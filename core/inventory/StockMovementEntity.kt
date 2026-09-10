package com.asteam.wcrm.core.inventory

/**
 * مدل دامنه ثبت تغییرات موجودی.
 * این مدل مستقل از دیتابیس و UI است.
 */
data class StockMovementEntity(
    val id: Long,
    val productId: Long,
    val quantity: Int,
    val movementType: MovementType,
    val referenceId: String?,
    val createdAt: Long
)

/**
 * نوع عملیات روی موجودی.
 */
enum class MovementType {
    IN,
    OUT,
    ADJUSTMENT
}
