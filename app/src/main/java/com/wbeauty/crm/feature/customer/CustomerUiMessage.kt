package com.wbeauty.crm.feature.customer

sealed class CustomerUiMessage {
    data object None : CustomerUiMessage()
    data object Saved : CustomerUiMessage()
    data class Error(val message: String) : CustomerUiMessage()
}
