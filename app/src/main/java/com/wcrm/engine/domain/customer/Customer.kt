package com.wcrm.engine.domain.customer

/**
 * Core CRM Customer Entity.
 *
 * این Entity نباید شامل اطلاعات اختصاصی یک صنعت باشد.
 * اطلاعات متغیر کسب و کارها از Custom Field Engine خوانده می‌شوند.
 */
data class Customer(
    val id: String,
    val name: String,
    val phone: String? = null,
    val email: String? = null
)
