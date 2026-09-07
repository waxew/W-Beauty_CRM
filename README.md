# W-Beauty CRM

## معرفی پروژه

W-Beauty CRM یک سیستم مدیریت ارتباط با مشتری (CRM) مبتنی بر Kotlin و Jetpack Compose است.

هدف اصلی پروژه ساخت یک هسته CRM مستقل از نوع کسب‌وکار است تا بتوان از یک سورس، نسخه‌های مختلف CRM برای صنایع مختلف تولید کرد.

نمونه نسخه‌ها:

- CRM سالن زیبایی
- CRM کلینیک
- CRM شرکت فروش
- CRM شرکت خدماتی
- CRM املاک
- CRM سازمان‌های مختلف

---

# معماری اصلی

ساختار کلان پروژه:

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
```

هسته برنامه نباید وابسته به یک صنعت خاص باشد.

---

# Business Profile System

Business Profile مشخص می‌کند هر نسخه CRM برای چه کسب‌وکاری ساخته شده است.

مسئولیت‌های Profile:

- نام CRM
- نام سازمان
- لوگو و تصاویر
- رنگ سازمانی
- متن‌ها
- Package Configuration
- Module های فعال
- Attribute Schema های فعال

ساختار:

```
business_profile/

├── BusinessProfile.kt
├── BusinessRegistry.kt
├── CRMIndustryType.kt
├── ModuleType.kt
├── AttributeSchema.kt
│
└── profiles/
```

---

# تفاوت Module و Attribute Schema

## Module

برای قابلیت‌هایی که منطق، فرآیند و Workflow دارند.

مثال:

- Customer
- Lead
- Pipeline
- Appointment
- Reservation
- Invoice
- Warranty
- Repair

## Attribute Schema

برای اطلاعات متغیر و اختصاصی هر کسب‌وکار.

مثال:

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

این اطلاعات نباید به صورت Field ثابت داخل Core Entity قرار بگیرند.

---

# CRM Core Rules

نمونه اشتباه:

```
Customer {
 skinType
 bloodType
 imei
}
```

نمونه صحیح:

```
Customer Core
        +
Custom Field Engine
        +
Attribute Schema
```

---

# تکنولوژی‌ها

- Kotlin
- Jetpack Compose
- Material 3
- MVVM
- Clean Architecture
- Hilt Dependency Injection
- Room Database
- Kotlin Coroutines / Flow
- Navigation Compose
- KSP

---

# لایه‌های پروژه

```
UI
 |
ViewModel
 |
UseCase
 |
Repository
 |
Database
```

---

# Business Profile های CRM

نمونه Profile ها:

```
beauty_center_001
clinic_001
sales_company_001
realestate_001
service_company_001
```

---

# Business Profile های فروشگاهی

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

# اضافه کردن کسب‌وکار جدید

برای ساخت CRM جدید:

1. یک Business Profile جدید ایجاد کنید.
2. Industry Type مشخص کنید.
3. Module های مورد نیاز را فعال کنید.
4. Attribute Schema های اختصاصی را تعریف کنید.
5. Core را تغییر ندهید.

---

# وضعیت توسعه

وضعیت فعلی:

Active Development

تمرکز فعلی:

- تکمیل Business Profile Runtime
- تکمیل Module Engine
- تکمیل Custom Field Engine
- اتصال Core CRM به Profile های مختلف

تمام توسعه‌ها باید معماری Core مستقل از Industry را حفظ کنند.
