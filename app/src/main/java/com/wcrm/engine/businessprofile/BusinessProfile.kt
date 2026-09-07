package com.wcrm.engine.businessprofile

/**
 * Defines a business configuration independently from CRM core logic.
 * Business types are runtime configurations, not core modules.
 */
data class BusinessProfile(
    val id: String,
    val name: String,
    val enabledModules: List<String> = emptyList(),
    val schemaIds: List<String> = emptyList()
)
