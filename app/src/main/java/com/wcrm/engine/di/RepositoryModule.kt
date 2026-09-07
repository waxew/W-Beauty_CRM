package com.wcrm.engine.di

import com.wcrm.engine.data.repository.CustomerRepositoryImpl
import com.wcrm.engine.domain.customer.CustomerRepository

/**
 * Dependency bindings for domain repositories.
 * Business specific configuration must not be placed here.
 */
object RepositoryModule {
    fun provideCustomerRepository(): CustomerRepository {
        return CustomerRepositoryImpl()
    }
}
