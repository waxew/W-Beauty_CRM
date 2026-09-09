package com.wcrm.engine.businessprofile.profiles.auto_parts

import com.wcrm.engine.businessprofile.*

object ProfileConfig {
    val profile = BusinessProfile(
        id = "auto_parts",
        name = "فروشگاه قطعات خودرو",
        enabled = false,
        enabledModules = listOf("CRM", "SALES", "INVENTORY", "REPAIR", "ADS"),
        schemaIds = listOf("auto_parts_product", "vehicle_customer"),
        ui = BusinessUiConfig(
            themeId = "auto_parts",
            iconSetId = "auto_parts_icons",
            illustrationSetId = "auto_parts_illustrations",
            homeTitle = "مدیریت قطعات خودرو",
            homeSubtitle = "فروش، موجودی، سازگاری خودرو و خدمات",
            dashboardItems = listOf(
                DashboardItemConfig("customers", "مشتریان", "person", "customers"),
                DashboardItemConfig("parts", "قطعات", "settings", "inventory"),
                DashboardItemConfig("sales", "فروش", "point_of_sale", "sales"),
                DashboardItemConfig("repair", "خدمات/تعمیر", "build", "repair")
            ),
            productFields = listOf(
                FieldConfig("part_number", "شماره قطعه", FieldType.SERIAL, true),
                FieldConfig("brand", "برند", required = true),
                FieldConfig("vehicle_brand", "برند خودرو"),
                FieldConfig("vehicle_model", "مدل خودرو"),
                FieldConfig("model_year", "سال سازگاری"),
                FieldConfig("oem_code", "کد OEM", FieldType.SERIAL),
                FieldConfig("location", "محل انبار")
            ),
            terminology = mapOf("product" to "قطعه", "inventory" to "موجودی قطعات")
        )
    )
}
