package com.wcrm.engine.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wcrm.engine.core.customer.AddCustomerUseCase
import com.wcrm.engine.core.customer.Customer
import com.wcrm.engine.core.customer.DeleteCustomerUseCase
import com.wcrm.engine.core.customer.ObserveCustomersUseCase
import com.wcrm.engine.core.customer.SearchCustomersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/** ViewModel واقعی صفحه مشتریان؛ هیچ داده Mock در آن وجود ندارد. */
@HiltViewModel
class CustomerViewModel @Inject constructor(
    observeCustomers: ObserveCustomersUseCase,
    searchCustomers: SearchCustomersUseCase,
    private val addCustomer: AddCustomerUseCase,
    private val deleteCustomer: DeleteCustomerUseCase
) : ViewModel() {

    val query = MutableStateFlow("")
    val error = MutableStateFlow<String?>(null)

    @OptIn(ExperimentalCoroutinesApi::class)
    val customers: StateFlow<List<Customer>> = query
        .flatMapLatest { value ->
            if (value.isBlank()) observeCustomers() else searchCustomers(value)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun setQuery(value: String) {
        query.value = value
    }

    fun add(name: String, phone: String) {
        viewModelScope.launch {
            runCatching {
                addCustomer(Customer(name = name.trim(), phone = phone.trim()))
            }.onSuccess {
                error.value = null
            }.onFailure {
                error.value = it.message ?: "خطا در ثبت مشتری"
            }
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch {
            runCatching { deleteCustomer(id) }
                .onFailure { error.value = it.message ?: "خطا در حذف مشتری" }
        }
    }
}
