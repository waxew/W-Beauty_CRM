package com.wcrm.engine.businessprofile.profiles.jewelry_store

import com.wcrm.engine.businessprofile.*

object ProfileConfig {
    val profile = BusinessProfile(
        id = "jewelry_store",
        name = "طلافروشی و جواهرات",
        enabled = false,
        enabledModules = listOf("CRM", "SALES", "INVENTORY", "ADS"),
        schemaIds = listOf("jewelry_product", "jewelry_customer"),
        ui = BusinessUiConfig(
            themeId = "jewelry_store",
            iconSetId = "jewelry_store_icons",
            illustrationSetId = "jewelry_store_illustrations",
            homeTitle = "مدیریت طلافروشی",
            homeSubtitle = "فروش، وزن، عیار، اجرت و موجودی",
            dashboardItems = listOf(
                DashboardItemConfig("customers", "مشتریان", "person", "customers"),
                DashboardItemConfig("products", "محصولات", "diamond", "inventory"),
                DashboardItemConfig("sales", "فروش", "point_of_sale", "sales"),
                DashboardItemConfig("inventory", "موجودی", "inventory_2", "inventory")
            ),
            productFields = listOf(
                FieldConfig("title", "عنوان", required = true),
                FieldConfig("weight", "وزن", FieldType.NUMBER, true),
                FieldConfig("purity", "عیار", FieldType.NUMBER, true),
                FieldConfig("labor_fee", "اجرت", FieldType.MONEY),
                FieldConfig("stone", "سنگ/نگین"),
                FieldConfig("serial", "کد/سریال", FieldType.SERIAL)
            ),
            terminology = mapOf("product" to "طلا/جواهر", "inventory" to "موجودی طلا")
        )
    )
}
