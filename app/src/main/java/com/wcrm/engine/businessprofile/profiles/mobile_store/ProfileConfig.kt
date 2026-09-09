package com.wcrm.engine.businessprofile.profiles.mobile_store

import com.wcrm.engine.businessprofile.*

object MobileStoreProfile {
    /**
     * Profile پیش‌فرض نمونه پروژه. برای ساخت نسخه صنف دیگر، این مقدار را false
     * و enabled همان Profile را true کنید؛ در هر خروجی اختصاصی فقط یک Profile فعال باشد.
     */
    val profile = BusinessProfile(
        id = "mobile_store",
        name = "فروشگاه موبایل",
        enabled = true,
        enabledModules = listOf("CRM", "SALES", "INVENTORY", "WARRANTY", "REPAIR", "ADS"),
        schemaIds = listOf("mobile_product", "mobile_customer"),
        ui = BusinessUiConfig(
            themeId = "tech_mobile",
            iconSetId = "mobile_store_icons",
            illustrationSetId = "mobile_store_illustrations",
            homeTitle = "مدیریت فروشگاه موبایل",
            homeSubtitle = "فروش، موجودی، IMEI، گارانتی و تعمیرات",
            dashboardItems = listOf(
                DashboardItemConfig("customers", "مشتریان", "person", "customers"),
                DashboardItemConfig("devices", "گوشی‌ها", "smartphone", "inventory"),
                DashboardItemConfig("sales", "فروش", "point_of_sale", "sales"),
                DashboardItemConfig("warranty", "گارانتی", "verified", "warranty"),
                DashboardItemConfig("repair", "تعمیرات", "build", "repair")
            ),
            productFields = listOf(
                FieldConfig("brand", "برند", required = true),
                FieldConfig("model", "مدل", required = true),
                FieldConfig("imei", "IMEI", FieldType.SERIAL, true),
                FieldConfig("storage", "حافظه"),
                FieldConfig("ram", "RAM"),
                FieldConfig("color", "رنگ"),
                FieldConfig("warranty", "گارانتی")
            ),
            terminology = mapOf("product" to "گوشی/دستگاه", "inventory" to "موجودی دستگاه")
        )
    )
}
