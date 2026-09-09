package com.wcrm.engine.businessprofile.profiles.beauty_center

import com.wcrm.engine.businessprofile.*

object BeautyCenterProfile {
    val profile = BusinessProfile(
        id = "beauty_center",
        name = "مرکز زیبایی",
        enabled = false,
        enabledModules = listOf("CRM", "APPOINTMENT", "SALES", "ADS"),
        schemaIds = listOf("beauty_customer", "beauty_service"),
        ui = BusinessUiConfig(
            themeId = "beauty_center",
            iconSetId = "beauty_center_icons",
            illustrationSetId = "beauty_center_illustrations",
            homeTitle = "مدیریت مرکز زیبایی",
            homeSubtitle = "مشتریان، نوبت‌ها، خدمات و پرداخت‌ها",
            dashboardItems = listOf(
                DashboardItemConfig("customers", "مشتریان", "person", "customers"),
                DashboardItemConfig("appointments", "نوبت‌ها", "event", "appointments"),
                DashboardItemConfig("services", "خدمات", "spa", "services"),
                DashboardItemConfig("sales", "پرداخت‌ها", "payments", "sales")
            ),
            productFields = listOf(
                FieldConfig("service_name", "نام خدمت", required = true),
                FieldConfig("duration", "مدت زمان", FieldType.NUMBER),
                FieldConfig("price", "هزینه", FieldType.MONEY, true)
            ),
            customerFields = listOf(
                FieldConfig("skin_type", "نوع پوست"),
                FieldConfig("hair_history", "سابقه مو"),
                FieldConfig("notes", "یادداشت تخصصی")
            ),
            terminology = mapOf("product" to "خدمت", "inventory" to "مواد مصرفی")
        )
    )
}
