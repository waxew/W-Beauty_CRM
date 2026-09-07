package com.wcrm.engine.runtime

import com.wcrm.engine.customfield.CustomFieldDefinition

/**
 * نام فایل: BusinessRuntime.kt
 * وظیفه: اتصال Business Profile به Runtime برنامه.
 * ارتباط: Profile -> Runtime -> Module/Schema Resolution
 * نکات توسعه: این کلاس نباید Industry خاص را بشناسد.
 */
data class BusinessRuntime(
    val businessId: String,
    val enabledModules: List<String>,
    val customSchemas: List<CustomFieldDefinition>
)
