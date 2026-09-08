package com.wcrm.engine.core

sealed class EngineResult<out T> {
    data class Success<T>(val data: T) : EngineResult<T>()
    data class Error(val message: String, val cause: Throwable? = null) : EngineResult<Nothing>()
}
