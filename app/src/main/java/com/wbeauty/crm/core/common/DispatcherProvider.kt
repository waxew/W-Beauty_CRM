package com.wbeauty.crm.core.common

import kotlinx.coroutines.CoroutineDispatcher

/**
 * مدیریت Dispatcher های برنامه برای اجرای امن Coroutine ها.
 */
interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
}
