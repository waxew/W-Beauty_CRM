# وضعیت معماری Business Profile System

## هدف

ساخت یک CRM Engine مستقل از نوع کسب و کار.

## معماری

CRM Core Engine

+

Business Profile

+

Module Registry

+

Attribute Schema Engine

+

Runtime Resolver

## قوانین

- هیچ Industry نباید داخل Core Hard Code شود.
- Module برای قابلیت های دارای Workflow است.
- Attribute Schema برای داده های متغیر است.
- Customer Core فقط اطلاعات عمومی را نگهداری می کند.

## Profile های فروشگاهی

- mobile_store_001
- boutique_store_001
- cosmetics_store_001
- home_appliance_store_001
- auto_parts_store_001
- jewelry_store_001
- book_store_001
- grocery_store_001
- pet_store_001
- omnichannel_store_001
