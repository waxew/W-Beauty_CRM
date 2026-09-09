# W-CRM

## معرفی پروژه

W-CRM یک موتور CRM عمومی مبتنی بر Kotlin و Jetpack Compose است که برای ساخت چندین برنامه مستقل از یک هسته مشترک طراحی شده است.

هدف پروژه:

- یک Core مشترک
- چند Business Profile مستقل
- ساخت نسخه‌های اختصاصی برای هر کسب‌وکار بدون کپی کردن کل پروژه

---

# معماری کلان

```
App Config
    |
    +-- Application Identity
    +-- Theme
    +-- Ads
    +-- Update System
    |
Business Profile Engine
    |
    +-- Enabled Modules
    +-- Schema Configuration
    +-- Dashboard Layout
    +-- UI Theme
    +-- Assets
    |
CRM Core
    |
    +-- Domain
    +-- Data
    +-- Repository
    +-- UseCase
    +-- UI
```

---

# App Config

تمام اطلاعات اختصاصی هر برنامه باید در یک نقطه مرکزی تعریف شود.

نمونه اطلاعات:

- نام برنامه
- نام شرکت
- لوگو
- آیکون
- رنگ اصلی
- اطلاعات تماس
- تنظیمات تبلیغات
- تنظیمات آپدیت
- تنظیمات Splash و Logo Motion

هدف: ساخت برنامه جدید فقط با تغییر Configuration انجام شود، نه تغییر پراکنده در کد.

---

# Business Profile System

نوع کسب‌وکار توسط توسعه‌دهنده تعیین می‌شود.

هر Profile دارای وضعیت فعال/غیرفعال است:

```
mobile_store = true
boutique = false
jewelry_store = false
```

در هر نسخه فقط Profile فعال بارگذاری می‌شود.

---

# پروفایل‌های کسب‌وکار

- Mobile Store
- Boutique
- Cosmetics Store
- Home Appliance
- Auto Parts
- Jewelry Store
- Book Store
- Grocery
- Pet Store
- Omnichannel

هر Profile می‌تواند داشته باشد:

- داشبورد اختصاصی
- آیکون و تصاویر اختصاصی
- فیلدهای اختصاصی
- Theme اختصاصی
- Moduleهای فعال

---

# تفاوت Module و Schema

Module برای منطق برنامه است:

- Customer
- Product
- Sales
- Invoice
- Inventory
- Warranty
- Repair
- Delivery

Schema برای اطلاعات متغیر کسب‌وکار است.

مثال:

موبایل:

```
IMEI
Brand
Model
Storage
Color
```

بوتیک:

```
Size
Color
Material
Season
```

---

# Ads System

تبلیغات باید از App Config کنترل شود.

```
ads.enabled = true / false
```

قوانین:

- کاربر VIP فعال: تبلیغ نمایش داده نمی‌شود.
- کاربر مهمان یا اشتراک منقضی: تبلیغ فعال می‌شود.

---

# Update System

برنامه در شروع اجرا نسخه جدید را بررسی می‌کند.

در صورت وجود نسخه جدید:

- Popup نمایش داده می‌شود.
- Notification نمایش داده می‌شود.
- نشان قرمز کنار بخش اعلان‌ها فعال می‌شود.

---

# ساختار UI عمومی

تمام برنامه‌ها دارای:

- Header سه بخشی
- Drawer مشترک
- Profile User
- Settings
- About
- Contact Us
- Backup / Restore
- Update

اما محتوای Dashboard و صفحات بر اساس Business Profile تغییر می‌کند.

---

# Backup و Restore

Backup:

- خروجی گرفتن از اطلاعات کاربر
- ذخیره فایل پشتیبان

Restore:

- انتخاب فایل از File Manager
- بازیابی اطلاعات

---

# اصول توسعه

1. Core نباید وابسته به صنعت باشد.
2. اطلاعات ثابت در Config قرار می‌گیرند.
3. از Hard Code کردن اطلاعات کسب‌وکار جلوگیری می‌شود.
4. هر تغییر باید با توضیحات فارسی ثبت شود.
5. قبل از حذف هر Feature باید بررسی معماری انجام شود.

---

# وضعیت توسعه

مراحل فعلی:

- تکمیل Business Profile Engine
- تکمیل App Config
- تکمیل UI Framework مشترک
- اتصال Moduleها به Backend واقعی
- تکمیل Dynamic Schema
- تست نهایی Build و Release
