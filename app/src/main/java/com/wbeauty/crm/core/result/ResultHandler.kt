package com.wbeauty.crm.core.result

/**
 * مدیریت نتیجه عملیات برنامه
 *
 * تمام لایه‌ها از این ساختار برای انتقال
 * موفقیت، خطا و وضعیت بارگذاری استفاده می‌کنند.
 */
sealed class ResultHandler<out T> {

    /** عملیات با موفقیت انجام شده است */
    data class Success<T>(val data: T) : ResultHandler<T>()

    /** عملیات در حال انجام است */
    object Loading : ResultHandler<Nothing>()

    /** عملیات با خطا مواجه شده است */
    data class Error(val message: String) : ResultHandler<Nothing>()
}
