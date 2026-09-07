package com.wbeauty.crm.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wbeauty.crm.data.local.dao.CustomerDao
import com.wbeauty.crm.data.local.entity.CustomerEntity

@Database(
    entities = [CustomerEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun customerDao(): CustomerDao
}
