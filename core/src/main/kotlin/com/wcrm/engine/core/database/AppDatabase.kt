package com.wcrm.engine.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wcrm.engine.core.customer.CustomerDao
import com.wcrm.engine.core.customer.CustomerEntity

/**
 * پایگاه‌داده محلی اصلی W-CRM.
 * هر Entity عمومی Core باید از طریق migration کنترل‌شده به این Database اضافه شود.
 */
@Database(
    entities = [CustomerEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao
}
