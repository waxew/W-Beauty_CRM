package com.wcrm.engine.businessprofile

/**
 * تنظیمات نمایشی هر Business Profile.
 *
 * این مدل باعث می‌شود Core و Screenهای مشترک، بدون Hardcode کردن نوع کسب‌وکار،
 * عنوان‌ها، داشبورد، واژگان و فیلدهای اختصاصی را از Profile فعال دریافت کنند.
 */
data class BusinessUiConfig(
    val themeId: String,
    val iconSetId: String,
    val illustrationSetId: String,
    val homeTitle: String,
    val homeSubtitle: String,
    val dashboardItems: List<DashboardItemConfig>,
    val productFields: List<FieldConfig>,
    val customerFields: List<FieldConfig> = emptyList(),
    val terminology: Map<String, String> = emptyMap()
)

/** کارت/میانبر قابل نمایش در داشبورد همان کسب‌وکار. */
data class DashboardItemConfig(
    val id: String,
    val title: String,
    val iconKey: String,
    val route: String
)

/** فیلد قابل استفاده توسط فرم‌ساز پویا. */
data class FieldConfig(
    val key: String,
    val label: String,
    val type: FieldType = FieldType.TEXT,
    val required: Boolean = false
)

enum class FieldType {
    TEXT,
    NUMBER,
    MONEY,
    DATE,
    BOOLEAN,
    BARCODE,
    SERIAL,
    PHONE,
    EMAIL
}
