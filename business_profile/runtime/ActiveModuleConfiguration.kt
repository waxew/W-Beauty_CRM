/*
================================================
نام فایل:
ActiveModuleConfiguration.kt

وظیفه:
نگهداری وضعیت Module های فعال Business Runtime.

ارتباط:
Business Profile
Module Registry
Runtime Configuration

نکات توسعه:
Module ها دارای Workflow هستند و نباید به Attribute Schema تبدیل شوند.
================================================
*/

package com.wbeauty.crm.business_profile.runtime

/**
 * وضعیت Module فعال در یک CRM Instance.
 */
data class ActiveModuleConfiguration(
    val moduleName: String,
    val enabled: Boolean = true
)
