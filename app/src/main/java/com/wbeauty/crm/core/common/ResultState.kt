package com.wbeauty.crm.core.common

/**
 * وضعیت‌های عمومی برای مدیریت نتیجه عملیات‌ها در برنامه.
 *
 * این کلاس پایه برای یکپارچه‌سازی پاسخ‌های موفق، خطا و بارگذاری
 * در تمام بخش‌های CRM استفاده می‌شود.
 */
sealed class ResultState<out T> {
    class Loading : ResultState<Nothing>()
    data class Success<T>(val data: T) : ResultState<T>()
    data class Error(val message: String) : ResultState<Nothing>()
}
