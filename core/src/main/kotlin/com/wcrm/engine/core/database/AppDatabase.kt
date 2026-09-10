package com.wcrm.engine.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wcrm.engine.core.customer.CustomerDao
import com.wcrm.engine.core.customer.CustomerEntity
import com.wcrm.engine.core.product.ProductDao
import com.wcrm.engine.core.product.ProductEntity

/**
 * پایگاه‌داده محلی اصلی W-CRM.
 * هر Entity عمومی Core باید فقط همراه Migration کنترل‌شده به نسخه جدید اضافه شود.
 */
@Database(
    entities = [
        CustomerEntity::class,
        ProductEntity::class
    ],
    version = 2,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao
    abstract fun productDao(): ProductDao
}
