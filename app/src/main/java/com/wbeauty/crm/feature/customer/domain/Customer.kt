package com.wbeauty.crm.feature.customer.domain

// مدل تجاری مشتری در لایه Domain
// مستقل از دیتابیس و رابط کاربری

data class Customer(
    val id: Long,
    val name: String,
    val phone: String
)
