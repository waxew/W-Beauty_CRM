package com.wbeauty.crm.feature.customer.presentation

// وضعیت نمایش صفحه مشتریان
// این کلاس وضعیت فعلی اطلاعات مشتری را نگهداری می‌کند.
data class CustomerUiState(
    val isLoading: Boolean = false,
    val message: String? = null
)
