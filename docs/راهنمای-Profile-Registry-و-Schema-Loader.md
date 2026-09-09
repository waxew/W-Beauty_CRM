# راهنمای فارسی Profile Registry و Schema Loader

## هدف

این لایه برای جلوگیری از Hardcode شدن کسب‌وکارها در Core ساخته شده است. از این پس Core، Navigation و فرم‌ساز نباید نام `mobile_store`، `boutique` یا هیچ صنعت دیگری را شرط‌گذاری کنند.

## ساختار استاندارد

```text
assets/
├── business_profiles/
│   ├── mobile_store.json
│   ├── boutique.json
│   └── profile_11.json
└── schemas/
    ├── mobile_store_product.json
    ├── boutique_product.json
    └── profile_11_product.json

ProfileRegistry
      ↓
BusinessProfile
      ↓
SchemaLoader
      ↓
BusinessRuntime
      ↓
Dynamic UI / Modules
```

## قانون فعال‌سازی

برنامه‌نویس در فایل Profile مقدار `enabled` را تعیین می‌کند. در خروجی اختصاصی دقیقاً یک Profile باید `true` باشد.

```json
{
  "id": "mobile_store",
  "enabled": true
}
```

کاربر نهایی نوع کسب‌وکار را انتخاب نمی‌کند.

## افزودن Profile یازدهم

برای اضافه‌کردن Profile جدید:

1. یک فایل JSON جدید در `assets/business_profiles` ایجاد کنید.
2. در صورت نیاز یک یا چند Schema در `assets/schemas` اضافه کنید.
3. شناسه Schemaها را در `schemaIds` همان Profile قرار دهید.
4. برای خروجی اختصاصی، `enabled=true` را فقط برای Profile موردنظر تنظیم کنید.

هیچ تغییر دیگری در `ProfileRegistry`، `SchemaLoader`، `Navigation` یا Core مجاز نیست.

## قرارداد Profile

فایل Profile می‌تواند شامل این بخش‌ها باشد:

- `id`: شناسه یکتا
- `name`: نام فارسی/نمایشی
- `enabled`: فعال یا غیرفعال
- `enabledModules`: ماژول‌های فعال
- `schemaIds`: Schemaهای موردنیاز
- `ui.themeId`: تم
- `ui.iconSetId`: مجموعه آیکون
- `ui.illustrationSetId`: مجموعه تصاویر
- `ui.dashboardItems`: کارت‌های داشبورد
- `ui.productFields`: فیلدهای نمایشی محصول
- `ui.customerFields`: فیلدهای نمایشی مشتری
- `ui.terminology`: واژگان اختصاصی صنف

## قرارداد Schema

Schema فقط داده متغیر کسب‌وکار را تعریف می‌کند و نباید Entityهای Core را تغییر دهد.

```json
{
  "id": "sample.product",
  "fields": [
    {"key":"serial","label":"شماره سریال","type":"TEXT","required":true}
  ]
}
```

انواع فعلی Schema: `TEXT`، `NUMBER`، `DATE` و `BOOLEAN`.

## قوانین توسعه

- شرط‌هایی مانند `if (profile.id == "mobile_store")` در Core ممنوع است.
- افزودن صنعت جدید نباید نیازمند تغییر Registry باشد.
- Schema ناشناخته باید خطا ایجاد کند؛ نباید بی‌صدا نادیده گرفته شود.
- شناسه Profile و Schema باید یکتا باشد.
- UI باید محتوا را از Profile فعال دریافت کند.
- منطق تخصصی واقعی فقط در Module/Extension مستقل قرار می‌گیرد، نه در Core عمومی.

## مسیر داده

```text
Profile JSON
   ↓
ProfileJsonParser
   ↓
ProfileRegistry
   ↓
Active Profile
   ↓
SchemaLoader
   ↓
BusinessProfileLoader
   ↓
BusinessRuntime
   ↓
UI / Feature Resolution
```

این ساختار مبنای تکمیل هر ۱۰ Profile و همه Profileهای آینده است.
