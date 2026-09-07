package com.wbeauty.crm.feature.customer

sealed class CustomerUiState {
    object Loading : CustomerUiState()
    data class Success(val count: Int) : CustomerUiState()
    data class Error(val message: String) : CustomerUiState()
}
