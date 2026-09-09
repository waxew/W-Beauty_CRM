package com.wcrm.engine.businessprofile.profiles.home_appliance

import com.wcrm.engine.businessprofile.*

object ProfileConfig {
    val profile = BusinessProfile(
        id = "home_appliance",
        name = "فروشگاه لوازم خانگی",
        enabled = false,
        enabledModules = listOf("CRM", "SALES", "INVENTORY", "WARRANTY", "DELIVERY", "ADS"),
        schemaIds = listOf("home_appliance_product", "home_appliance_customer"),
        ui = BusinessUiConfig(
            themeId = "home_appliance",
            iconSetId = "home_appliance_icons",
            illustrationSetId = "home_appliance_illustrations",
            homeTitle = "مدیریت لوازم خانگی",
            homeSubtitle = "فروش، انبار، سریال، گارانتی و تحویل",
            dashboardItems = listOf(
                DashboardItemConfig("customers", "مشتریان", "person", "customers"),
                DashboardItemConfig("products", "محصولات", "kitchen", "inventory"),
                DashboardItemConfig("sales", "فروش", "point_of_sale", "sales"),
                DashboardItemConfig("warranty", "گارانتی", "verified", "warranty"),
                DashboardItemConfig("delivery", "تحویل", "local_shipping", "delivery")
            ),
            productFields = listOf(
                FieldConfig("brand", "برند", required = true),
                FieldConfig("model", "مدل", required = true),
                FieldConfig("serial", "شماره سریال", FieldType.SERIAL, true),
                FieldConfig("category", "دسته‌بندی"),
                FieldConfig("energy_grade", "رده انرژی"),
                FieldConfig("warranty", "گارانتی")
            ),
            terminology = mapOf("product" to "دستگاه", "inventory" to "موجودی لوازم خانگی")
        )
    )
}
