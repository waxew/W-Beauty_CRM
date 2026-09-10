package com.wcrm.engine.core.customer

/**
 * مدل دامنه مشتری.
 * این مدل مستقل از Room و UI است تا لایه دامنه به دیتابیس یا رابط کاربری وابسته نشود.
 */
data class Customer(
    val id: Long = 0,
    val name: String,
    val phone: String,
    val mobile: String? = null,
    val address: String? = null,
    val email: String? = null,
    val notes: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
