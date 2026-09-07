package com.wbeauty.crm.business_profile.profiles

import com.wbeauty.crm.business_profile.CRMIndustryType

/*
نام فایل:
SalesCompany001Profile.kt

وظیفه:
تعریف CRM شرکت فروش.

نکات توسعه:
Lead و Pipeline ماژول هستند و اطلاعات فروش مشتری Attribute Schema است.
*/
object SalesCompany001Profile {
    const val id = "sales_company_001"
    val industry = CRMIndustryType.SALES_COMPANY
    val enabledModules = listOf("CUSTOMER", "LEAD", "OPPORTUNITY", "PIPELINE", "TASK", "REMINDER")
    val customerAttributes = listOf("industry", "customer_level")
}
