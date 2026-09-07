package com.wbeauty.crm.feature.customer

sealed interface CustomerEvent {
    data class NameChanged(val value: String) : CustomerEvent
    data class PhoneChanged(val value: String) : CustomerEvent
    data object Save : CustomerEvent
}
