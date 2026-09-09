package com.wbeauty.crm.domain.usecase

import com.wbeauty.crm.data.local.entity.CustomerEntity
import com.wbeauty.crm.data.repository.CustomerRepository
import javax.inject.Inject

class GetCustomersUseCase @Inject constructor(
    private val repository: CustomerRepository
) {
    operator fun invoke() = repository.getCustomers()
}

class AddCustomerUseCase @Inject constructor(
    private val repository: CustomerRepository
) {
    suspend operator fun invoke(name: String, phone: String) {
        repository.addCustomer(
            CustomerEntity(
                name = name,
                phone = phone
            )
        )
    }
}
