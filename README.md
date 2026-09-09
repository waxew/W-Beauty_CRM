# W-CRM

## معرفی پروژه

W-CRM یک موتور CRM عمومی مبتنی بر Kotlin و Jetpack Compose است که برای ساخت چند برنامه مستقل از یک هسته مشترک طراحی شده است.

هدف پروژه این است که توسعه‌دهنده با تغییر تنظیمات برنامه و فعال‌کردن یک Business Profile بتواند خروجی مستقل برای یک صنف تولید کند، بدون اینکه Core برای هر کسب‌وکار کپی یا بازنویسی شود.

---

# معماری کلان

```text
AppConfig
   ↓
ProfileEngine
   ├── ProfileRegistry
   ├── SchemaLoader
   └── BusinessProfileLoader
          ↓
      BusinessRuntime
          ↓
   Module / Schema / UI Resolution
          ↓
CRM Core
   ├── Domain
   ├── Data
   ├── Repository
   ├── UseCase
   └── Presentation
```

اصل پایه: Core نباید نام یا منطق اختصاصی یک صنعت را بشناسد.

---

# AppConfig

اطلاعات هویتی و عمومی برنامه در `AppConfig.kt` متمرکز می‌شوند:

- نام برنامه
- لوگو و آیکون
- اطلاعات AS Team
- ایمیل پشتیبانی
- تبلیغات
- VIP
- Update
- Splash / Logo Motion
- Header
- Drawer
- Backup / Restore
- قواعد Navigation

نسخه Runtime از `BuildConfig` خوانده می‌شود تا با نسخه Gradle هماهنگ بماند.

---

# Profile Registry استاندارد

Registry دیگر هیچ لیست Hardcode از صنایع ندارد.

تمام Profileها از مسیر زیر کشف می‌شوند:

```text
app/src/main/assets/business_profiles/
```

برای خروجی اختصاصی دقیقاً یک فایل Profile باید داشته باشد:

```json
"enabled": true
```

اگر صفر یا بیش از یک Profile فعال باشد، برنامه پیکربندی را نامعتبر تلقی می‌کند.

## افزودن Profile یازدهم

برای اضافه‌کردن Profile جدید فقط:

1. یک JSON جدید در `assets/business_profiles` اضافه کنید.
2. Schemaهای موردنیاز را در `assets/schemas` اضافه کنید.
3. شناسه Schemaها را در `schemaIds` همان Profile قرار دهید.
4. در صورت ساخت خروجی آن Profile، فقط همان Profile را `enabled=true` کنید.

هیچ تغییری در Registry، Loader، Navigation یا Core لازم نیست.

---

# Schema Loader

Schemaهای متغیر کسب‌وکار از این مسیر خوانده می‌شوند:

```text
app/src/main/assets/schemas/
```

Schema Loader:

- همه فایل‌های JSON را کشف می‌کند.
- شناسه‌های تکراری را رد می‌کند.
- Schema ناشناخته را خطا می‌داند.
- Schemaهای Profile فعال را به `BusinessRuntime` منتقل می‌کند.

نمونه:

```json
{
  "id": "mobile_store.product",
  "fields": [
    {"key":"imei","label":"IMEI","type":"TEXT","required":true}
  ]
}
```

Attributeهای صنفی نباید داخل Entityهای عمومی Core اضافه شوند.

---

# Business Profileهای فعلی

ده Profile فعلی سورس:

1. `mobile_store` — فروشگاه موبایل
2. `beauty_center` — مرکز زیبایی
3. `jewelry_store` — طلا و جواهر
4. `auto_parts` — قطعات خودرو
5. `home_appliance` — لوازم خانگی
6. `book_store` — کتاب‌فروشی
7. `grocery` — مواد غذایی
8. `pet_store` — پت‌شاپ
9. `boutique` — بوتیک و پوشاک
10. `omnichannel` — فروش چندکاناله

هر Profile می‌تواند به‌صورت مستقل تعریف کند:

- Moduleهای فعال
- Schemaها
- Theme
- Icon Set
- Illustration Set
- Dashboard
- Product Fields
- Customer Fields
- Terminology

---

# UI Profile-aware

Screenهای عمومی نباید برای هر صنف کپی شوند. Profile تعیین می‌کند چه چیزی نمایش داده شود.

مثال موبایل:

```text
مشتریان
فروش
موجودی دستگاه‌ها
گارانتی
تعمیرات
```

مثال بوتیک:

```text
مشتریان
فروش
موجودی پوشاک
بازاریابی
```

در صورت نیاز به UX واقعاً اختصاصی، Module Extension مستقل اضافه می‌شود؛ Core عمومی همچنان بدون شناخت صنعت باقی می‌ماند.

---

# مسیر مرجع داده

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
UI / Module Resolver
```

این مسیر مرجع است و نباید در Screenها دوباره پیاده‌سازی شود.

---

# Ads و VIP

کنترل تبلیغات از `AppConfig.Ads` انجام می‌شود.

قانون مرکزی:

- Ads خاموش → تبلیغ نمایش داده نمی‌شود.
- VIP فعال → تبلیغ نمایش داده نمی‌شود.
- Guest یا اشتراک غیرفعال + Ads روشن → تبلیغ مجاز است.

UI نباید این منطق را دوباره Hardcode کند.

---

# Update System

هدف سیستم Update:

- بررسی نسخه در شروع برنامه
- Popup هنگام وجود نسخه جدید
- ثبت اعلان نسخه جدید
- نشان قرمز در بخش اعلان‌ها
- نمایش نسخه فعلی در Drawer

پیاده‌سازی شبکه Update باید از `AppConfig.Update` پیکربندی شود.

---

# UI Framework مشترک

چارچوب عمومی همه خروجی‌ها:

- Header سه بخشی
- Drawer سمت راست
- پروفایل کاربر
- Settings
- Notifications
- About
- Contact Us
- Share
- Backup / Restore
- Update

ظاهر و محتوای تجاری باید از Business Profile فعال بیاید.

---

# Backup / Restore

Backup باید تمام داده‌های قابل بازیابی کاربر را به یک فایل پشتیبان نسخه‌دار تبدیل کند.

Restore باید:

- فایل را از File Manager دریافت کند.
- نسخه و صحت فایل را بررسی کند.
- داده را به‌صورت کنترل‌شده بازیابی کند.

---

# قواعد Navigation

- Back داخل همان Flow به صفحه قبلی برمی‌گردد.
- ورود از Drawer یا Section Menu به Flow دیگر نباید History بخش قبلی را حفظ کند.
- Back از Flow جدید باید مستقیم به Home برگردد.
- زنجیره صفحات نامرتبط نباید روی Back Stack انباشته شود.

---

# استاندارد Backend هر Feature

هر Feature کامل باید این زنجیره را داشته باشد:

```text
Screen
  ↓
ViewModel
  ↓
UseCase
  ↓
Repository
  ↓
DataSource / DAO
  ↓
Database
```

صرف داشتن Route یا FeatureFlag به معنی تکمیل Feature نیست.

---

# قوانین توسعه

1. حذف یا کوچک‌سازی Feature برای گرفتن Build ممنوع است.
2. Core نباید شرط مستقیم بر اساس شناسه صنعت داشته باشد.
3. اطلاعات ثابت برنامه باید از Config خوانده شوند.
4. اطلاعات متغیر صنف باید در Profile/Schema باشند.
5. افزودن Profile جدید نباید Registry را تغییر دهد.
6. Schema ناشناخته نباید بی‌صدا نادیده گرفته شود.
7. کامنت‌های معماری و فایل‌های راهنما فارسی باشند.
8. هر تغییر مهم باید Build شود و خطای واقعی CI بررسی شود.

---

# وضعیت توسعه فعلی

تکمیل‌شده یا برقرار:

- AppConfig مرکزی
- ۱۰ Business Profile
- Profile Registry مبتنی بر Asset Discovery
- Schema Loader مستقل
- Profile Engine مرکزی
- UI Dashboard مبتنی بر Profile
- BuildConfig برای نسخه Runtime
- راهنمای فارسی افزودن Profile جدید

در حال تکمیل:

- Backend کامل Sales
- Backend کامل Inventory
- Invoice
- Warranty
- Repair
- Delivery
- Marketing
- Header / Drawer کامل
- Backup / Restore واقعی
- Update Checker واقعی
- Notification Center
- تست یکپارچه و Release نهایی

تا زمانی که زنجیره Backend و UI برای Featureهای بالا کامل و تست نشده باشد، پروژه از نظر محصول نهایی کامل محسوب نمی‌شود.
