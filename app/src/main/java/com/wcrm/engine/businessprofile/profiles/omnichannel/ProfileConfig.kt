package com.wcrm.engine.businessprofile.profiles.omnichannel

import com.wcrm.engine.businessprofile.*

object ProfileConfig {
    val profile = BusinessProfile(
        id = "omnichannel",
        name = "فروش چندکاناله",
        enabled = false,
        enabledModules = listOf("CRM", "SALES", "INVENTORY", "DELIVERY", "ADS"),
        schemaIds = listOf("omnichannel_product", "omnichannel_customer", "sales_channel"),
        ui = BusinessUiConfig(
            themeId = "omnichannel",
            iconSetId = "omnichannel_icons",
            illustrationSetId = "omnichannel_illustrations",
            homeTitle = "مدیریت فروش چندکاناله",
            homeSubtitle = "فروش حضوری و آنلاین، انبار، سفارش و ارسال",
            dashboardItems = listOf(
                DashboardItemConfig("customers", "مشتریان", "person", "customers"),
                DashboardItemConfig("orders", "سفارش‌ها", "receipt_long", "sales"),
                DashboardItemConfig("inventory", "موجودی", "inventory_2", "inventory"),
                DashboardItemConfig("delivery", "ارسال", "local_shipping", "delivery")
            ),
            productFields = listOf(
                FieldConfig("sku", "SKU", FieldType.SERIAL, true),
                FieldConfig("name", "نام محصول", required = true),
                FieldConfig("barcode", "بارکد", FieldType.BARCODE),
                FieldConfig("channel", "کانال فروش"),
                FieldConfig("online_price", "قیمت آنلاین", FieldType.MONEY),
                FieldConfig("store_price", "قیمت حضوری", FieldType.MONEY)
            ),
            terminology = mapOf("product" to "محصول", "inventory" to "موجودی یکپارچه")
        )
    )
}
