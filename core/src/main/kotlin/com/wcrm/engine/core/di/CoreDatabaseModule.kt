package com.wcrm.engine.core.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.wcrm.engine.core.customer.CustomerDao
import com.wcrm.engine.core.customer.CustomerRepository
import com.wcrm.engine.core.customer.CustomerRepositoryImpl
import com.wcrm.engine.core.database.AppDatabase
import com.wcrm.engine.core.product.ProductDao
import com.wcrm.engine.core.product.ProductRepository
import com.wcrm.engine.core.product.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Migration نسخه ۱ به ۲: اضافه شدن جدول محصولات بدون حذف داده‌های مشتری. */
private val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            """
            CREATE TABLE IF NOT EXISTS products (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                name TEXT NOT NULL,
                category TEXT,
                brand TEXT,
                price INTEGER NOT NULL,
                cost INTEGER NOT NULL,
                stock INTEGER NOT NULL,
                createdAt INTEGER NOT NULL,
                updatedAt INTEGER NOT NULL
            )
            """.trimIndent()
        )
    }
}

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
        )
            .addMigrations(MIGRATION_1_2)
            .build()

    @Provides
    fun provideCustomerDao(database: AppDatabase): CustomerDao = database.customerDao()

    @Provides
    fun provideProductDao(database: AppDatabase): ProductDao = database.productDao()
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

    @Binds
    @Singleton
    abstract fun bindProductRepository(
        implementation: ProductRepositoryImpl
    ): ProductRepository
}
