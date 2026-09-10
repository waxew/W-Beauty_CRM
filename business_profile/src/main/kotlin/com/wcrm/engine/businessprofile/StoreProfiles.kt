package com.wcrm.engine.businessprofile

/**
 * کاتالوگ واقعی ۱۰ پروفایل فروشگاهی.
 * UI و Runtime باید فقط از این تعریف‌ها استفاده کنند و شرط‌های پراکنده صنعت‌محور نداشته باشند.
 */
object StoreProfiles {

    private fun a(id: String, label: String, type: AttributeType = AttributeType.TEXT, required: Boolean = false) =
        AttributeDefinition(id, label, type, required)

    private fun w(id: String, title: String, priority: Int) =
        DashboardWidget(id, title, id, priority)

    val mobileStore = BusinessProfile(
        id = "mobile_store_001",
        title = "فروشگاه موبایل",
        enabled = true,
        modules = setOf(BusinessModule.DASHBOARD, BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY, BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.WARRANTY, BusinessModule.REPAIR, BusinessModule.SERIAL_IMEI, BusinessModule.ACCOUNTING),
        attributes = listOf(a("brand", "برند", required = true), a("model", "مدل", required = true), a("imei", "IMEI"), a("serial", "شماره سریال"), a("storage", "حافظه"), a("ram", "RAM"), a("color", "رنگ"), a("warranty", "گارانتی")),
        dashboardWidgets = listOf(w("sales_today", "فروش امروز", 1), w("device_stock", "موجودی دستگاه", 2), w("open_repairs", "تعمیرات باز", 3), w("active_warranties", "گارانتی فعال", 4), w("profit_today", "سود امروز", 5)),
        ui = ProfileUiConfig("mobile", "hero_mobile", productLabel = "دستگاه")
    )

    val boutiqueStore = BusinessProfile(
        "boutique_store_001", "بوتیک و پوشاک", false,
        setOf(BusinessModule.DASHBOARD, BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY, BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.ACCOUNTING),
        listOf(a("brand", "برند"), a("size", "سایز", required = true), a("color", "رنگ"), a("material", "جنس"), a("season", "فصل"), a("collection", "کالکشن")),
        listOf(w("sales_today", "فروش امروز", 1), w("size_stock", "موجودی سایزها", 2), w("popular_colors", "رنگ‌های پرفروش", 3), w("low_stock", "کمبود موجودی", 4), w("collection_sales", "فروش کالکشن", 5)),
        ProfileUiConfig("boutique", "hero_boutique", productLabel = "پوشاک")
    )

    val cosmeticsStore = BusinessProfile(
        "cosmetics_store_001", "فروشگاه آرایشی و بهداشتی", false,
        setOf(BusinessModule.DASHBOARD, BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY, BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.ACCOUNTING),
        listOf(a("brand", "برند"), a("volume", "حجم"), a("expiration_date", "تاریخ انقضا", AttributeType.DATE), a("batch_number", "شماره بچ"), a("country", "کشور سازنده"), a("category", "دسته‌بندی")),
        listOf(w("expiring_soon", "نزدیک انقضا", 1), w("top_brand", "برند پرفروش", 2), w("stock", "موجودی", 3), w("sales_today", "فروش امروز", 4)),
        ProfileUiConfig("cosmetics", "hero_cosmetics")
    )

    val homeApplianceStore = BusinessProfile(
        "home_appliance_store_001", "لوازم خانگی", false,
        setOf(BusinessModule.DASHBOARD, BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY, BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.WARRANTY, BusinessModule.DELIVERY, BusinessModule.ACCOUNTING),
        listOf(a("brand", "برند"), a("model", "مدل"), a("serial", "شماره سریال"), a("warranty", "گارانتی"), a("installation_required", "نیاز به نصب", AttributeType.BOOLEAN), a("after_sales", "خدمات پس از فروش")),
        listOf(w("sales_today", "فروش امروز", 1), w("stock", "موجودی", 2), w("active_warranties", "گارانتی فعال", 3), w("pending_installations", "نصب‌های در انتظار", 4)),
        ProfileUiConfig("home_appliance", "hero_home_appliance")
    )

    val autoPartsStore = BusinessProfile(
        "auto_parts_store_001", "لوازم یدکی خودرو", false,
        setOf(BusinessModule.DASHBOARD, BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY, BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.WARRANTY, BusinessModule.ACCOUNTING),
        listOf(a("brand", "برند"), a("part_number", "شماره قطعه", required = true), a("oem_code", "کد OEM"), a("vehicle_compatibility", "خودروهای سازگار")),
        listOf(w("sales_today", "فروش امروز", 1), w("stock", "موجودی", 2), w("low_stock", "کمبود موجودی", 3), w("top_vehicle", "خودروی پرتکرار", 4)),
        ProfileUiConfig("auto_parts", "hero_auto_parts", productLabel = "قطعه")
    )

    val jewelryStore = BusinessProfile(
        "jewelry_store_001", "طلا و جواهر", false,
        setOf(BusinessModule.DASHBOARD, BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY, BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.ACCOUNTING),
        listOf(a("weight", "وزن", AttributeType.DECIMAL, true), a("karat", "عیار"), a("stone", "سنگ"), a("labor_cost", "اجرت", AttributeType.DECIMAL), a("price_basis", "مبنای قیمت")),
        listOf(w("inventory_weight", "وزن موجودی", 1), w("sales_today", "فروش امروز", 2), w("profit", "سود", 3), w("price_alert", "هشدار قیمت", 4)),
        ProfileUiConfig("jewelry", "hero_jewelry", productLabel = "قطعه طلا")
    )

    val bookStore = BusinessProfile(
        "book_store_001", "کتاب‌فروشی", false,
        setOf(BusinessModule.DASHBOARD, BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY, BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.ACCOUNTING),
        listOf(a("isbn", "ISBN", required = true), a("author", "نویسنده"), a("publisher", "ناشر"), a("edition", "نوبت چاپ"), a("category", "دسته‌بندی")),
        listOf(w("sales_today", "فروش امروز", 1), w("stock", "موجودی کتاب", 2), w("top_authors", "نویسندگان پرفروش", 3), w("low_stock", "کتاب‌های رو به اتمام", 4)),
        ProfileUiConfig("books", "hero_books", productLabel = "کتاب")
    )

    val groceryStore = BusinessProfile(
        "grocery_store_001", "سوپرمارکت", false,
        setOf(BusinessModule.DASHBOARD, BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY, BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.ACCOUNTING),
        listOf(a("barcode", "بارکد"), a("expiration_date", "تاریخ انقضا", AttributeType.DATE), a("batch_number", "شماره بچ"), a("supplier", "تامین‌کننده"), a("unit", "واحد فروش")),
        listOf(w("sales_today", "فروش امروز", 1), w("expiring_soon", "نزدیک انقضا", 2), w("low_stock", "کمبود موجودی", 3), w("top_categories", "دسته‌های پرفروش", 4)),
        ProfileUiConfig("grocery", "hero_grocery")
    )

    val petStore = BusinessProfile(
        "pet_store_001", "پت‌شاپ", false,
        setOf(BusinessModule.DASHBOARD, BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY, BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.ACCOUNTING),
        listOf(a("animal_category", "نوع حیوان"), a("brand", "برند"), a("age_group", "گروه سنی"), a("expiration_date", "تاریخ انقضا", AttributeType.DATE), a("product_type", "نوع محصول")),
        listOf(w("sales_today", "فروش امروز", 1), w("expiring_soon", "نزدیک انقضا", 2), w("low_stock", "کمبود موجودی", 3), w("top_animal_category", "گروه حیوانی پرفروش", 4)),
        ProfileUiConfig("pet", "hero_pet")
    )

    val omnichannelStore = BusinessProfile(
        "omnichannel_store_001", "فروش چندکاناله", false,
        setOf(BusinessModule.DASHBOARD, BusinessModule.CUSTOMER, BusinessModule.PRODUCT, BusinessModule.INVENTORY, BusinessModule.SALES, BusinessModule.INVOICE, BusinessModule.ACCOUNTING, BusinessModule.DELIVERY),
        listOf(a("channel", "کانال فروش"), a("external_order_id", "شناسه سفارش خارجی"), a("fulfillment_type", "روش تامین"), a("warehouse", "انبار"), a("delivery_status", "وضعیت ارسال")),
        listOf(w("total_sales", "فروش کل", 1), w("online_sales", "فروش آنلاین", 2), w("offline_sales", "فروش حضوری", 3), w("pending_delivery", "ارسال‌های در انتظار", 4), w("channel_performance", "عملکرد کانال‌ها", 5)),
        ProfileUiConfig("omnichannel", "hero_omnichannel")
    )

    val all: List<BusinessProfile> = listOf(
        mobileStore,
        boutiqueStore,
        cosmeticsStore,
        homeApplianceStore,
        autoPartsStore,
        jewelryStore,
        bookStore,
        groceryStore,
        petStore,
        omnichannelStore
    )
}
