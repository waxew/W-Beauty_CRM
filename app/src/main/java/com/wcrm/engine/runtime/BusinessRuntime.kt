package com.wcrm.engine.runtime

import com.wcrm.engine.businessprofile.BusinessUiConfig
import com.wcrm.engine.customfield.CustomFieldDefinition

/**
 * اتصال Business Profile فعال به Runtime برنامه.
 *
 * زنجیره مرجع:
 * BusinessProfile -> BusinessRuntime -> Module/Schema/UI Resolution
 *
 * این کلاس نباید هیچ صنعت مشخصی را Hardcode کند. تمام تفاوت‌های صنفی باید از
 * Profile فعال دریافت شوند.
 */
data class BusinessRuntime(
    val businessId: String,
    val enabledModules: List<String>,
    val customSchemas: List<CustomFieldDefinition>,
    val schemaIds: List<String> = emptyList(),
    val uiConfig: BusinessUiConfig? = null
)
