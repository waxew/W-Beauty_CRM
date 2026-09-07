package com.wbeauty.crm.feature.customer.presentation

// وضعیت فرم ثبت مشتری
// این کلاس برای نگهداری اطلاعات ورودی فرم مشتری استفاده می‌شود.
data class CustomerFormState(
    val name: String = "",
    val phone: String = "",
    val note: String = ""
)
