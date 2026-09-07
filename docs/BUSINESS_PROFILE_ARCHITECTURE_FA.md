# معماری Business Profile CRM

## هدف
ساخت CRM Core Engine مستقل از نوع کسب و کار.

## تفکیک Module و Attribute Schema

### Module
قابلیت هایی که دارای منطق، عملیات و Workflow هستند.

مثال:
- Customer
- Lead
- Pipeline
- Appointment
- Repair
- Warranty
- Sales

### Attribute Schema
اطلاعات متغیر و توصیفی که فقط داده هستند.

مثال:
- Skin Type
- Blood Type
- IMEI
- Size
- Color

## قانون اصلی
هیچ Attribute اختصاصی نباید به صورت Field ثابت داخل Core Entity قرار گیرد.

صحیح:
Customer Core + Custom Field Schema

اشتباه:
Customer { skinType, bloodType }

## Business Profile مسئول:

1. انتخاب Module های فعال
2. انتخاب Attribute Schema های فعال برای هر Entity
3. تنظیم Identity و ظاهر CRM

## مثال

Beauty CRM:
- Module: Reservation
- Attribute: Skin Type

Clinic CRM:
- Module: Appointment
- Attribute: Blood Type

Sales CRM:
- Module: Pipeline
- Attribute: Customer Level
