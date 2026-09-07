package com.wcrm.engine.feature

interface FeatureModule {
    val id: String
    fun isEnabled(): Boolean = true
}
