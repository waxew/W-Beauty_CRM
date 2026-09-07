package com.wbeauty.crm.business_profile

/*
================================================
نام فایل:
ModuleRegistry.kt

وظیفه:
مدیریت Module های فعال در CRM بر اساس Business Profile.

ارتباط:
Business Profile مشخص می‌کند چه قابلیت‌هایی فعال باشند و Core فقط از این Registry استفاده می‌کند.

نکات توسعه:
منطق Industry نباید داخل Core نوشته شود.
Module دارای Workflow و منطق است و با Attribute Schema اشتباه نشود.
================================================
*/

object ModuleRegistry {
    private var enabledModules: Set<ModuleType> = emptySet()

    fun initialize(modules: Set<ModuleType>) {
        enabledModules = modules
    }

    fun isEnabled(module: ModuleType): Boolean {
        return enabledModules.contains(module)
    }

    fun getEnabledModules(): Set<ModuleType> {
        return enabledModules
    }
}
