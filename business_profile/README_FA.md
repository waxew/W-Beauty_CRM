# راهنمای فارسی Business Profile System

## Business Profile چیست؟

Business Profile لایه تنظیمات یک CRM Instance است و مشخص می‌کند یک نسخه CRM برای چه سازمانی، چه صنعتی و با چه قابلیت‌هایی ساخته می‌شود.

Core CRM نباید اطلاعات یک صنعت خاص را بشناسد.

## ساخت CRM جدید

برای ساخت نسخه جدید:

1. یک Profile جدید در مسیر profiles ایجاد کنید.
2. شناسه یکتا تعریف کنید.
3. Module های مورد نیاز را فعال کنید.
4. Attribute Schema های اختصاصی را تعریف کنید.

## تفاوت Module و Attribute Schema

Module:

قابلیت دارای منطق، عملیات و Workflow است.

مثال:

- Reservation
- Warranty
- Repair
- Delivery

Attribute Schema:

اطلاعات متغیر و توصیفی است.

مثال:

- Size
- Color
- IMEI
- Blood Type

## قوانین Core

نباید Industry Field داخل Entity های اصلی قرار گیرد.

صحیح:

Customer Core + Custom Schema

غلط:

Customer + SkinType + IMEI + BloodType

## اضافه کردن صنعت جدید

صنعت جدید باید فقط با اضافه کردن Profile، Module و Schema جدید ساخته شود و نباید باعث تغییر در Core CRM شود.
