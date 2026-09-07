package com.wbeauty.crm.feature.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wbeauty.crm.domain.usecase.AddCustomerUseCase
import com.wbeauty.crm.domain.usecase.GetCustomersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(
    private val getCustomersUseCase: GetCustomersUseCase,
    private val addCustomerUseCase: AddCustomerUseCase
) : ViewModel() {

    val customers = getCustomersUseCase()

    fun addCustomer(name: String, phone: String) {
        viewModelScope.launch {
            addCustomerUseCase(name, phone)
        }
    }
}
