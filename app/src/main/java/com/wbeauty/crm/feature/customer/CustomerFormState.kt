package com.wbeauty.crm.feature.customer

data class CustomerFormState(
    val name: String = "",
    val phone: String = "",
    val error: String? = null,
    val saved: Boolean = false
)
