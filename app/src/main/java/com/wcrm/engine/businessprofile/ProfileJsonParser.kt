package com.wcrm.engine.businessprofile

import org.json.JSONObject

/** پارسر متمرکز تعریف Profile؛ هیچ منطق صنفی در این فایل وجود ندارد. */
internal object ProfileJsonParser {
    fun parse(json: String): BusinessProfile {
        val root = JSONObject(json)
        val uiObject = root.optJSONObject("ui")

        return BusinessProfile(
            id = root.getString("id"),
            name = root.optString("name", root.getString("id")),
            enabled = root.optBoolean("enabled", false),
            enabledModules = root.stringList("enabledModules"),
            enabledFeatures = root.stringList("enabledFeatures"),
            schemaIds = root.stringList("schemaIds"),
            visualProfileId = root.optString("visualProfileId", root.getString("id")),
            dashboardProfileId = root.optString("dashboardProfileId", root.getString("id")),
            terminologyProfileId = root.optString("terminologyProfileId", root.getString("id")),
            ui = uiObject?.toUiConfig()
        )
    }

    private fun JSONObject.toUiConfig(): BusinessUiConfig {
        val dashboard = optJSONArray("dashboardItems")
        val productFields = optJSONArray("productFields")
        val customerFields = optJSONArray("customerFields")
        val terminologyObject = optJSONObject("terminology")

        return BusinessUiConfig(
            themeId = optString("themeId", "default"),
            iconSetId = optString("iconSetId", "default"),
            illustrationSetId = optString("illustrationSetId", "default"),
            homeTitle = optString("homeTitle", "W-CRM"),
            homeSubtitle = optString("homeSubtitle", "مدیریت کسب‌وکار"),
            dashboardItems = buildList {
                if (dashboard != null) for (i in 0 until dashboard.length()) {
                    val item = dashboard.getJSONObject(i)
                    add(DashboardItemConfig(item.getString("id"), item.getString("title"), item.optString("iconKey", item.getString("id")), item.getString("route")))
                }
            },
            productFields = productFields.toFields(),
            customerFields = customerFields.toFields(),
            terminology = buildMap {
                if (terminologyObject != null) terminologyObject.keys().forEach { key -> put(key, terminologyObject.optString(key)) }
            }
        )
    }

    private fun org.json.JSONArray?.toFields(): List<FieldConfig> = buildList {
        if (this@toFields != null) for (i in 0 until length()) {
            val field = getJSONObject(i)
            val type = runCatching { FieldType.valueOf(field.optString("type", "TEXT")) }.getOrDefault(FieldType.TEXT)
            add(FieldConfig(field.getString("key"), field.getString("label"), type, field.optBoolean("required", false)))
        }
    }

    private fun JSONObject.stringList(key: String): List<String> = buildList {
        val array = optJSONArray(key) ?: return@buildList
        for (i in 0 until array.length()) add(array.getString(i))
    }
}
