package com.wcrm.engine.customfield

/**
 * Registry for resolving dynamic schemas by business profile.
 * Business specific attributes must be provided through this layer,
 * not hard-coded inside core entities.
 */
class SchemaRegistry {
    private val schemas = mutableMapOf<String, CustomFieldSchema>()

    fun register(profileId: String, schema: CustomFieldSchema) {
        schemas[profileId] = schema
    }

    fun resolve(profileId: String): CustomFieldSchema? {
        return schemas[profileId]
    }
}
