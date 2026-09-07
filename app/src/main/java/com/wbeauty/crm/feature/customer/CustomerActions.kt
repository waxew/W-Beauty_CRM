package com.wbeauty.crm.feature.customer

sealed class CustomerAction {
    data class NameChanged(val value: String) : CustomerAction()
    data class PhoneChanged(val value: String) : CustomerAction()
    data object Save : CustomerAction()
}
