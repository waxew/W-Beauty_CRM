package com.wcrm.engine.businessprofile.profiles.book_store

import com.wcrm.engine.businessprofile.*

object ProfileConfig {
    val profile = BusinessProfile(
        id = "book_store",
        name = "کتاب‌فروشی",
        enabled = false,
        enabledModules = listOf("CRM", "SALES", "INVENTORY", "ADS"),
        schemaIds = listOf("book_product", "book_customer"),
        ui = BusinessUiConfig(
            themeId = "book_store",
            iconSetId = "book_store_icons",
            illustrationSetId = "book_store_illustrations",
            homeTitle = "مدیریت کتاب‌فروشی",
            homeSubtitle = "فروش، موجودی کتاب، ناشر و دسته‌بندی",
            dashboardItems = listOf(
                DashboardItemConfig("customers", "مشتریان", "person", "customers"),
                DashboardItemConfig("books", "کتاب‌ها", "menu_book", "inventory"),
                DashboardItemConfig("sales", "فروش", "point_of_sale", "sales"),
                DashboardItemConfig("inventory", "موجودی", "inventory_2", "inventory")
            ),
            productFields = listOf(
                FieldConfig("title", "عنوان کتاب", required = true),
                FieldConfig("author", "نویسنده", required = true),
                FieldConfig("publisher", "ناشر"),
                FieldConfig("isbn", "ISBN", FieldType.BARCODE, true),
                FieldConfig("category", "دسته‌بندی"),
                FieldConfig("edition", "چاپ/ویرایش")
            ),
            terminology = mapOf("product" to "کتاب", "inventory" to "موجودی کتاب")
        )
    )
}
