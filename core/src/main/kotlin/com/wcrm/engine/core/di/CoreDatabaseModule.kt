package com.wcrm.engine.core.di

import android.content.Context
import androidx.room.Room
import com.wcrm.engine.core.customer.CustomerDao
import com.wcrm.engine.core.customer.CustomerRepository
import com.wcrm.engine.core.customer.CustomerRepositoryImpl
import com.wcrm.engine.core.database.AppDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** وابستگی‌های پایگاه‌داده Core. */
@Module
@InstallIn(SingletonComponent::class)
object CoreDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "w_crm.db"
        ).build()

    @Provides
    fun provideCustomerDao(database: AppDatabase): CustomerDao = database.customerDao()
}

/** اتصال قراردادهای دامنه به پیاده‌سازی‌های Data. */
@Module
@InstallIn(SingletonComponent::class)
abstract class CoreRepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCustomerRepository(
        implementation: CustomerRepositoryImpl
    ): CustomerRepository
}
