package com.wbeauty.crm.feature.customer.presentation

// وضعیت نمایشی صفحه مشتریان
// این کلاس وضعیت‌های مورد نیاز UI مشتریان را نگهداری می‌کند.
data class CustomerUiState(
    val isLoading: Boolean = false,
    val message: String = ""
)
