package com.wcrm.engine.businessprofile.profiles.pet_store

import com.wcrm.engine.businessprofile.*

object ProfileConfig {
    val profile = BusinessProfile(
        id = "pet_store",
        name = "پت‌شاپ",
        enabled = false,
        enabledModules = listOf("CRM", "SALES", "INVENTORY", "ADS"),
        schemaIds = listOf("pet_product", "pet_customer"),
        ui = BusinessUiConfig(
            themeId = "pet_store",
            iconSetId = "pet_store_icons",
            illustrationSetId = "pet_store_illustrations",
            homeTitle = "مدیریت پت‌شاپ",
            homeSubtitle = "فروش، موجودی، گونه حیوان و تاریخ انقضا",
            dashboardItems = listOf(
                DashboardItemConfig("customers", "مشتریان", "person", "customers"),
                DashboardItemConfig("products", "محصولات", "pets", "inventory"),
                DashboardItemConfig("sales", "فروش", "point_of_sale", "sales"),
                DashboardItemConfig("inventory", "موجودی", "inventory_2", "inventory")
            ),
            productFields = listOf(
                FieldConfig("name", "نام محصول", required = true),
                FieldConfig("animal_type", "نوع حیوان", required = true),
                FieldConfig("brand", "برند"),
                FieldConfig("weight", "وزن/حجم"),
                FieldConfig("expiration", "تاریخ انقضا", FieldType.DATE),
                FieldConfig("barcode", "بارکد", FieldType.BARCODE)
            ),
            terminology = mapOf("product" to "محصول حیوانات", "inventory" to "موجودی پت‌شاپ")
        )
    )
}
