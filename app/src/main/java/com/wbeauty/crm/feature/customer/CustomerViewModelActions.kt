package com.wbeauty.crm.feature.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wbeauty.crm.domain.usecase.AddCustomerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerViewModelActions @Inject constructor(
    private val addCustomerUseCase: AddCustomerUseCase
) : ViewModel() {

    fun saveCustomer(name: String, phone: String) {
        viewModelScope.launch {
            addCustomerUseCase(name, phone)
        }
    }
}
