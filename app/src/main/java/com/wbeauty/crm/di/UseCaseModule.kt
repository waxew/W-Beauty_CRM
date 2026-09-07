package com.wbeauty.crm.di

import com.wbeauty.crm.domain.usecase.AddCustomerUseCase
import com.wbeauty.crm.domain.usecase.GetCustomersUseCase
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.Provides

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetCustomersUseCase(repository: com.wbeauty.crm.data.repository.CustomerRepository) = GetCustomersUseCase(repository)

    @Provides
    fun provideAddCustomerUseCase(repository: com.wbeauty.crm.data.repository.CustomerRepository) = AddCustomerUseCase(repository)
}
