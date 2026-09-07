package com.wcrm.engine.businessprofile

/**
 * Runtime module activation configuration.
 */
data class BusinessModuleConfig(
    val moduleName: String,
    val enabled: Boolean = true
)
