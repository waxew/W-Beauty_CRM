# W-CRM

## معرفی پروژه

W-CRM یک هسته CRM مستقل از نوع کسب‌وکار است که با Kotlin و Jetpack Compose توسعه داده می‌شود.

هدف پروژه این است که از یک سورس بتوان نسخه‌های مختلف CRM برای صنایع مختلف تولید کرد.

نمونه‌ها:

- CRM سالن زیبایی
- CRM کلینیک
- CRM شرکت فروش
- CRM خدماتی
- CRM املاک
- CRM فروشگاهی

---

# معماری اصلی

```
CRM Core Engine
        |
        +---- Business Profile System
        |
        +---- CRM Modules
        |
        +---- Custom Field Engine
        |
        +---- Database Layer
        |
        +---- Future Extensions (Ads Platform)
```

Core نباید شامل منطق اختصاصی یک صنعت باشد.

---

# Business Profile System

Business Profile مشخص می‌کند هر نسخه CRM چه تنظیماتی دارد:

- نام CRM
- نام سازمان
- لوگو
- رنگ سازمانی
- تصاویر
- متن‌ها
- Package Configuration
- Module های فعال
- Attribute Schema های فعال

---

# تفاوت Module و Attribute Schema

## Module

برای قابلیت‌هایی که دارای منطق و Workflow هستند:

- Customer
- Sales
- Invoice
- Reservation
- Appointment
- Warranty
- Repair
- Delivery

## Attribute Schema

برای اطلاعات متغیر کسب‌وکار:

کلینیک:

- Blood Type
- Medical Notes

سالن زیبایی:

- Skin Type
- Hair History

فروشگاه:

- IMEI
- Size
- Serial Number

این موارد نباید Field ثابت Core Entity باشند.

---

# قوانین Core

صحیح:

```
Customer Core
        +
Custom Field Engine
        +
Attribute Schema
```

غلط:

```
Customer {
 skinType
 bloodType
 imei
}
```

---

# Business Profile های فعلی

CRM:

```
beauty_center_001
clinic_001
sales_company_001
realestate_001
service_company_001
```

Store:

```
mobile_store_001
boutique_store_001
cosmetics_store_001
home_appliance_store_001
auto_parts_store_001
jewelry_store_001
book_store_001
grocery_store_001
pet_store_001
omnichannel_store_001
```

---

# ساخت CRM جدید

1. ایجاد Business Profile جدید
2. تعیین Industry Type
3. فعال کردن Moduleهای مورد نیاز
4. تعریف Attribute Schema
5. عدم تغییر Core

---

# وضعیت توسعه

تمرکز فعلی:

- تکمیل Business Profile Runtime
- تکمیل Module Engine
- تکمیل Custom Field Engine
- Refactor Core Entityها
- Build نهایی

تمام توسعه‌ها باید معماری مستقل از Industry را حفظ کنند.
