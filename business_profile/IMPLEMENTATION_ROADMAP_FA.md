# نقشه تکمیل Business Profile CRM

## وضعیت معماری

هدف: ساخت CRM مستقل از صنعت که با تغییر Business Profile بتواند نسخه‌های مختلف نرم‌افزار را تولید کند.

## مراحل تکمیل

### 1. Runtime Integration
- اتصال BusinessProfileResolver به Startup
- ساخت Active Business Runtime
- بارگذاری Module و Schema فعال

### 2. Custom Field Engine
- تعریف Schema
- ذخیره Value
- اتصال Repository و Database
- حذف Attributeهای صنعتی از Core Entity

### 3. Core Refactor
Core فقط داده‌های عمومی را نگهداری می‌کند:

- Name
- Phone
- Email
- Address
- Notes
- Communication History

اطلاعات صنعتی باید از Custom Schema خوانده شود.

### 4. Module Isolation
هر Module باید منطق، Data، Domain و Presentation مستقل داشته باشد.

### 5. Dynamic UI
رابط کاربری باید بر اساس Profile فعال ساخته شود و نباید شرط‌های وابسته به Industry داشته باشد.

### 6. Validation
سناریوهای تست:

- mobile_store_001
- beauty_center_001
- clinic_001

## قوانین توسعه

- هیچ Industry داخل Core Hard Code نشود.
- Module و Attribute Schema با هم مخلوط نشوند.
- هر Business Profile فقط تنظیمات و قابلیت‌ها را تعریف کند.
