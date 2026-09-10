package com.wcrm.engine.businessprofile

/** ماژول‌های قابل فعال‌سازی در CRM. */
enum class BusinessModule {
    DASHBOARD,
    CUSTOMER,
    PRODUCT,
    INVENTORY,
    SALES,
    INVOICE,
    WARRANTY,
    REPAIR,
    SERIAL_IMEI,
    ACCOUNTING,
    DELIVERY
}

/** نوع فیلد سفارشی برای فرم‌های داینامیک. */
enum class AttributeType { TEXT, NUMBER, DECIMAL, DATE, BOOLEAN, SELECT }

/** تعریف یک فیلد اختصاصی بدون آلوده کردن Entityهای Core. */
data class AttributeDefinition(
    val id: String,
    val label: String,
    val type: AttributeType,
    val required: Boolean = false,
    val options: List<String> = emptyList()
)

/** تعریف ویجت قابل نمایش در داشبورد پروفایل. */
data class DashboardWidget(
    val id: String,
    val title: String,
    val dataKey: String,
    val priority: Int = 0
)

/** هویت بصری و اصطلاحات قابل تغییر هر پروفایل. */
data class ProfileUiConfig(
    val themeKey: String,
    val heroAssetKey: String? = null,
    val productLabel: String = "محصول",
    val customerLabel: String = "مشتری",
    val inventoryLabel: String = "موجودی",
    val salesLabel: String = "فروش"
)

/** تعریف کامل Business Profile که Runtime و UI از آن تغذیه می‌شوند. */
data class BusinessProfile(
    val id: String,
    val title: String,
    val enabled: Boolean,
    val modules: Set<BusinessModule>,
    val attributes: List<AttributeDefinition>,
    val dashboardWidgets: List<DashboardWidget>,
    val ui: ProfileUiConfig
)
