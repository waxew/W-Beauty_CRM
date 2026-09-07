package com.wbeauty.crm.feature.customer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerViewModelFinal @Inject constructor(
    private val actions: CustomerViewModelActions
) : ViewModel() {

    fun onEvent(event: CustomerEvent) {
        viewModelScope.launch {
            actions.handle(event)
        }
    }
}
