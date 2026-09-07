package com.wbeauty.crm.business_profile.profiles

import com.wbeauty.crm.business_profile.CRMIndustryType

/*
نام فایل:
ServiceCompany001Profile.kt

وظیفه:
تعریف CRM شرکت خدماتی.

نکات توسعه:
Workflow های خدماتی از طریق Module مدیریت می‌شوند.
*/
object ServiceCompany001Profile {
    const val id = "service_company_001"
    val industry = CRMIndustryType.SERVICE_COMPANY
    val enabledModules = listOf("CUSTOMER", "TASK", "APPOINTMENT", "COMMUNICATION", "REPORT")
    val customerAttributes = listOf("service_type", "customer_priority")
}
