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

    fun all(): List<CustomFieldSchema> = schemas.values.sortedBy { it.id }

    fun get(id: String): CustomFieldSchema? = schemas[id]

    fun require(id: String): CustomFieldSchema = requireNotNull(get(id)) {
        "Schema با شناسه '$id' پیدا نشد."
    }

    fun load(ids: List<String>): List<CustomFieldSchema> = ids.map(::require)

    /**
     * تمام Schemaهای اعلام‌شده توسط یک Profile را یک‌جا بررسی می‌کند.
     * این متد برای Audit راه‌اندازی استفاده می‌شود تا Profile ناقص وارد Runtime نشود.
     */
    fun validateReferences(profileId: String, ids: List<String>) {
        val missing = ids.filterNot(schemas::containsKey)
        require(missing.isEmpty()) {
            "Profile '$profileId' به Schemaهای ناموجود اشاره می‌کند: $missing"
        }
    }

    private fun loadAllInternal(): Map<String, CustomFieldSchema> {
        val files = context.assets.list(SCHEMA_ASSET_DIR)
            ?.filter { it.endsWith(".json", ignoreCase = true) }
            ?.sorted()
            .orEmpty()

        require(files.isNotEmpty()) {
            "هیچ Schema در assets/$SCHEMA_ASSET_DIR پیدا نشد."
        }

        val loaded = files.map { fileName ->
            val json = context.assets.open("$SCHEMA_ASSET_DIR/$fileName")
                .bufferedReader()
                .use { it.readText() }
            parse(json, fileName)
        }

        val duplicateIds = loaded.groupingBy { it.id }.eachCount().filterValues { it > 1 }.keys
        require(duplicateIds.isEmpty()) { "شناسه تکراری Schema: $duplicateIds" }
        return loaded.associateBy { it.id }
    }

    private fun parse(json: String, fileName: String): CustomFieldSchema {
        val root = JSONObject(json)
        val id = root.getString("id").trim()
        require(id.isNotEmpty()) { "شناسه Schema در فایل $fileName خالی است." }

        val fieldsArray = root.optJSONArray("fields")
        val fields = buildList {
            if (fieldsArray != null) for (i in 0 until fieldsArray.length()) {
                val item = fieldsArray.getJSONObject(i)
                val key = item.getString("key").trim()
                val label = item.getString("label").trim()
                require(key.isNotEmpty()) { "کلید فیلد شماره $i در Schema '$id' خالی است." }
                require(label.isNotEmpty()) { "عنوان فیلد '$key' در Schema '$id' خالی است." }

                val rawType = item.optString("type", "TEXT").uppercase()
                val type = runCatching { CustomFieldType.valueOf(rawType) }
                    .getOrElse {
                        throw IllegalArgumentException(
                            "نوع فیلد '$rawType' برای '$key' در Schema '$id' پشتیبانی نمی‌شود."
                        )
                    }

                add(
                    CustomFieldDefinition(
                        key = key,
                        label = label,
                        type = type,
                        required = item.optBoolean("required", false)
                    )
                )
            }
        }

        val duplicateKeys = fields.groupingBy { it.key }.eachCount().filterValues { it > 1 }.keys
        require(duplicateKeys.isEmpty()) {
            "کلید فیلد تکراری در Schema '$id': $duplicateKeys"
        }

        return CustomFieldSchema(id = id, fields = fields)
    }

    companion object {
        private const val SCHEMA_ASSET_DIR = "schemas"
    }
}
