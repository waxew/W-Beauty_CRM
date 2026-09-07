package com.wbeauty.crm.feature.customer.data

// لایه دسترسی به اطلاعات مشتریان
// در نسخه کامل با Room DAO پیاده سازی می‌شود.
interface CustomerDao {
    fun getAll(): List<CustomerEntity>
}
