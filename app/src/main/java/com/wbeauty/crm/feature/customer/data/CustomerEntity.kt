package com.wbeauty.crm.feature.customer.data

// موجودیت اصلی مشتری در دیتابیس محلی برنامه CRM
// این کلاس پایه توسعه مدیریت مشتریان است.
data class CustomerEntity(
    val id: Long = 0,
    val name: String,
    val phone: String,
    val notes: String = ""
)
