package com.wbeauty.crm.core.customer.domain.model

/**
 * مدل پایه مشتری در هسته CRM.
 * این مدل مستقل از نوع کسب و کار است.
 */
data class Customer(
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val notes: String? = null
)
