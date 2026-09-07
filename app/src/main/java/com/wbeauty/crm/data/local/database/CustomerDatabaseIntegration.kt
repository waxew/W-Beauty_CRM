package com.wbeauty.crm.data.local.database

/**
 * اتصال تنظیمات دیتابیس مشتریان
 *
 * این فایل نقطه آماده‌سازی برای اضافه شدن Entity و DAO مشتریان به Room است.
 * در نسخه‌های بعدی Migration و نسخه‌بندی دیتابیس نیز در همین بخش مدیریت می‌شود.
 */
object CustomerDatabaseIntegration {
    const val CUSTOMER_TABLE = "customers"
    const val DATABASE_VERSION = 1
}
