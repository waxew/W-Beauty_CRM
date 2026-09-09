package com.wcrm.engine.customfield

import android.content.Context
import org.json.JSONObject

/**
 * بارگذار استاندارد Schemaها از assets/schemas.
 *
 * هیچ Schema صنفی در Core ثبت نمی‌شود. هر Profile فقط شناسه Schemaهای موردنیاز را
 * اعلام می‌کند و این Loader آن‌ها را از فایل‌های مستقل JSON بارگذاری می‌کند.
 */
class SchemaLoader(private val context: Context) {
    private val schemas: Map<String, CustomFieldSchema> by lazy { loadAllInternal() }

    fun all(): List<CustomFieldSchema> = schemas.values.toList()

    fun get(id: String): CustomFieldSchema? = schemas[id]

    fun require(id: String): CustomFieldSchema = requireNotNull(get(id)) {
        "Schema با شناسه '$id' پیدا نشد."
    }

    fun load(ids: List<String>): List<CustomFieldSchema> = ids.map(::require)

    private fun loadAllInternal(): Map<String, CustomFieldSchema> {
        val files = context.assets.list(SCHEMA_ASSET_DIR)
            ?.filter { it.endsWith(".json", ignoreCase = true) }
            ?.sorted()
            .orEmpty()

        val loaded = files.map { fileName ->
            val json = context.assets.open("$SCHEMA_ASSET_DIR/$fileName")
                .bufferedReader()
                .use { it.readText() }
            parse(json)
        }

        val duplicateIds = loaded.groupingBy { it.id }.eachCount().filterValues { it > 1 }.keys
        require(duplicateIds.isEmpty()) { "شناسه تکراری Schema: $duplicateIds" }
        return loaded.associateBy { it.id }
    }

    private fun parse(json: String): CustomFieldSchema {
        val root = JSONObject(json)
        val fieldsArray = root.optJSONArray("fields")
        val fields = buildList {
            if (fieldsArray != null) for (i in 0 until fieldsArray.length()) {
                val item = fieldsArray.getJSONObject(i)
                val type = runCatching {
                    CustomFieldType.valueOf(item.optString("type", "TEXT"))
                }.getOrDefault(CustomFieldType.TEXT)

                add(
                    CustomFieldDefinition(
                        key = item.getString("key"),
                        label = item.getString("label"),
                        type = type,
                        required = item.optBoolean("required", false)
                    )
                )
            }
        }
        return CustomFieldSchema(id = root.getString("id"), fields = fields)
    }

    companion object {
        private const val SCHEMA_ASSET_DIR = "schemas"
    }
}
