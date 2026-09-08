package com.wcrm.engine.runtime.shared

/**
 * Runtime state container shared by application services.
 */
data class RuntimeContext(
    val activeProfile: String,
    val enabledFeatures: Set<String> = emptySet()
)
