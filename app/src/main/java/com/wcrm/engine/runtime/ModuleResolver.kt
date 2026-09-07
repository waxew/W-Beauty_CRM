package com.wcrm.engine.runtime

/**
 * Resolver responsible for determining enabled CRM modules
 * from Business Profile runtime configuration.
 *
 * Business domains must not be hard coded here.
 */
class ModuleResolver(
    private val enabledModules: Set<String>
) {
    fun isEnabled(moduleId: String): Boolean {
        return enabledModules.contains(moduleId)
    }

    fun getEnabledModules(): Set<String> {
        return enabledModules
    }
}
