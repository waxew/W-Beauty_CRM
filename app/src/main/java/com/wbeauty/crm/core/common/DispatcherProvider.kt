package com.wbeauty.crm.core.common

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}
