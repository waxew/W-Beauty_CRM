package com.wbeauty.crm.di

import android.content.Context
import androidx.room.Room
import com.wbeauty.crm.data.local.database.AppDatabase
import com.wbeauty.crm.data.local.dao.CustomerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "wbeauty.db"
    ).build()

    @Provides
    fun provideCustomerDao(
        database: AppDatabase
    ): CustomerDao = database.customerDao()
}
