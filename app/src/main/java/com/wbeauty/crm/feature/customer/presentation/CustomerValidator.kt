package com.wbeauty.crm.feature.customer.presentation

// اعتبارسنجی اطلاعات مشتری قبل از ذخیره سازی
// قوانین کامل کسب و کار در مراحل بعدی اضافه می‌شوند.

object CustomerValidator {
    fun isValid(name: String): Boolean {
        return name.isNotBlank()
    }
}
