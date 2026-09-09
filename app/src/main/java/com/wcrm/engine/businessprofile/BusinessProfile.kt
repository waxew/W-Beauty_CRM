package com.wcrm.engine.businessprofile

/**
 * Defines a business configuration independently from CRM core logic.
 * Business types are runtime configurations, not core modules.
 */
data class BusinessProfile(
    val id: String,
    val name: String = id,
    val enabledModules: List<String> = emptyList(),
    val enabledFeatures: List<String> = emptyList(),
    val schemaIds: List<String> = emptyList()
) {
    /**
     * Compatibility view used while migrating older profile definitions.
     */
    val modules: List<String>
        get() = if (enabledModules.isNotEmpty()) enabledModules else enabledFeatures
}
