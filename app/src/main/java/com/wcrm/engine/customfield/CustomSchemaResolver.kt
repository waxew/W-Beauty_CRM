package com.wcrm.engine.customfield

/**
 * Resolves dynamic Attribute Schema definitions at runtime.
 *
 * Core entities must remain independent from business-specific attributes.
 */
class CustomSchemaResolver(
    private val schemas: Map<String, List<CustomFieldDefinition>>
) {
    fun resolve(entityType: String): List<CustomFieldDefinition> {
        return schemas[entityType].orEmpty()
    }
}
