package com.wbeauty.crm.feature.customer.data

// تبدیل اطلاعات دیتابیس به مدل قابل استفاده در برنامه
object CustomerMapper {
    fun mapName(name: String): String {
        return name.trim()
    }
}
