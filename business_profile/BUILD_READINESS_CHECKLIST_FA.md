# چک لیست آماده سازی Build نهایی W-CRM

## وضعیت معماری

- [x] Business Profile Framework
- [x] Module و Attribute Schema تفکیک شده‌اند
- [x] Custom Field Engine طراحی شده است
- [x] Store Profile Catalog ایجاد شده است
- [x] Runtime Configuration پایه ایجاد شده است

## قبل از Build نهایی

- [ ] اتصال Runtime به Application Startup
- [ ] بررسی و اصلاح Core Entity ها
- [ ] حذف فیلدهای وابسته به صنعت از Core
- [ ] اتصال Custom Field به Database Migration
- [ ] تست فعال شدن Module ها بر اساس Business Profile
- [ ] تست Dynamic UI
- [ ] بررسی Dependency های Gradle

## سناریوهای تست

Mobile Store:
- Product
- Inventory
- Warranty
- Repair
- IMEI

Beauty Center:
- Customer
- Reservation
- Service
- Staff
- Loyalty

Clinic:
- Customer
- Appointment
- Medical History
- Staff
