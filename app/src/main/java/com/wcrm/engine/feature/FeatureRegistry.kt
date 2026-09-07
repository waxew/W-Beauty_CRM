package com.wcrm.engine.feature

class FeatureRegistry(
    private val modules: List<FeatureModule>
) {
    fun enabledModules(): List<FeatureModule> = modules.filter { it.isEnabled() }
}
