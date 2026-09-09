package com.wcrm.engine.businessprofile.profiles.grocery

import com.wcrm.engine.businessprofile.*

object ProfileConfig {
    val profile = BusinessProfile(
        id = "grocery",
        name = "فروشگاه مواد غذایی",
        enabled = false,
        enabledModules = listOf("CRM", "SALES", "INVENTORY", "ADS"),
        schemaIds = listOf("grocery_product", "grocery_customer"),
        ui = BusinessUiConfig(
            themeId = "grocery",
            iconSetId = "grocery_icons",
            illustrationSetId = "grocery_illustrations",
            homeTitle = "مدیریت فروشگاه مواد غذایی",
            homeSubtitle = "فروش، موجودی، بارکد و تاریخ انقضا",
            dashboardItems = listOf(
                DashboardItemConfig("customers", "مشتریان", "person", "customers"),
                DashboardItemConfig("products", "کالاها", "shopping_basket", "inventory"),
                DashboardItemConfig("sales", "فروش", "point_of_sale", "sales"),
                DashboardItemConfig("inventory", "موجودی", "inventory_2", "inventory")
            ),
            productFields = listOf(
                FieldConfig("name", "نام کالا", required = true),
                FieldConfig("barcode", "بارکد", FieldType.BARCODE, true),
                FieldConfig("brand", "برند"),
                FieldConfig("weight", "وزن/حجم"),
                FieldConfig("expiration", "تاریخ انقضا", FieldType.DATE),
                FieldConfig("batch", "سری ساخت", FieldType.SERIAL)
            ),
            terminology = mapOf("product" to "کالا", "inventory" to "موجودی کالا")
        )
    )
}
