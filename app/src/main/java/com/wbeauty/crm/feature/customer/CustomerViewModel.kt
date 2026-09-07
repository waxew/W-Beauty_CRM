package com.wbeauty.crm.feature.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wbeauty.crm.domain.usecase.AddCustomerUseCase
import com.wbeauty.crm.domain.usecase.GetCustomersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(
    private val getCustomersUseCase: GetCustomersUseCase,
    private val addCustomerUseCase: AddCustomerUseCase
) : ViewModel() {

    val customers = getCustomersUseCase()

    private val _saveState = MutableStateFlow<CustomerSaveResult>(CustomerSaveResult.Idle)
    val saveState: StateFlow<CustomerSaveResult> = _saveState.asStateFlow()

    fun addCustomer(name: String, phone: String) {
        if (name.isBlank() || phone.isBlank()) {
            _saveState.value = CustomerSaveResult.Error("اطلاعات مشتری کامل نیست")
            return
        }

        viewModelScope.launch {
            try {
                addCustomerUseCase(name, phone)
                _saveState.value = CustomerSaveResult.Success
            } catch (e: Exception) {
                _saveState.value = CustomerSaveResult.Error(e.message ?: "خطای ذخیره مشتری")
            }
        }
    }
}
