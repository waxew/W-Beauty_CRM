package com.wcrm.engine.businessprofile.profiles.boutique

import com.wcrm.engine.businessprofile.*

object ProfileConfig {
    val profile = BusinessProfile(
        id = "boutique",
        name = "بوتیک و پوشاک",
        enabled = false,
        enabledModules = listOf("CRM", "SALES", "INVENTORY", "ADS"),
        schemaIds = listOf("boutique_product", "boutique_customer"),
        ui = BusinessUiConfig(
            themeId = "fashion_boutique",
            iconSetId = "boutique_icons",
            illustrationSetId = "boutique_illustrations",
            homeTitle = "مدیریت بوتیک",
            homeSubtitle = "فروش، سایزبندی، رنگ‌بندی و موجودی پوشاک",
            dashboardItems = listOf(
                DashboardItemConfig("customers", "مشتریان", "person", "customers"),
                DashboardItemConfig("products", "محصولات", "checkroom", "inventory"),
                DashboardItemConfig("sales", "فروش", "point_of_sale", "sales"),
                DashboardItemConfig("inventory", "موجودی", "inventory_2", "inventory")
            ),
            productFields = listOf(
                FieldConfig("brand", "برند"),
                FieldConfig("category", "دسته‌بندی", required = true),
                FieldConfig("size", "سایز", required = true),
                FieldConfig("color", "رنگ", required = true),
                FieldConfig("material", "جنس"),
                FieldConfig("season", "فصل/کالکشن")
            ),
            terminology = mapOf("product" to "پوشاک", "inventory" to "موجودی پوشاک")
        )
    )
}
