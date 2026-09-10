# W-CRM

## معرفی پروژه

W-CRM یک هسته CRM مستقل از نوع کسب‌وکار است که با Kotlin و Jetpack Compose توسعه داده می‌شود.

هدف پروژه این است که از یک سورس بتوان نسخه‌های مختلف CRM برای صنایع مختلف تولید کرد.

## معماری اصلی

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
        +---- Future Extensions
```

Core نباید شامل منطق اختصاصی یک صنعت باشد.

## Business Profile System

Business Profile مشخص می‌کند هر نسخه CRM چه تنظیماتی دارد:

- نام CRM
- لوگو
- رنگ سازمانی
- Module های فعال
- Attribute Schema های فعال
- تنظیمات UI

## Module و Attribute Schema

Module ها شامل Workflow و منطق برنامه هستند:

- Customer
- Product
- Inventory
- Sales
- Invoice
- Warranty
- Repair
- Delivery

Attribute Schema اطلاعات اختصاصی هر کسب‌وکار را کنترل می‌کند.

مثال:

Mobile Store:
- IMEI
- RAM
- Storage
- Warranty

Boutique:
- Size
- Color
- Material
- Season

## مسیر تکمیل عملی پروژه

### Phase 1 - Core Backend

- Entity
- DAO
- Repository
- UseCase
- Database
- Dependency Injection

### Phase 2 - Business Runtime

- Profile Registry
- Active Profile Resolver
- Dynamic Modules
- Dynamic Navigation
- Custom Field Engine

### Phase 3 - Business Features

- Inventory
- Sales
- Invoice
- Warranty
- Repair
- Accounting
- Delivery

تمام تغییرات باید بدون حذف قابلیت‌های موجود، با Commit واقعی و بررسی Build انجام شوند.
