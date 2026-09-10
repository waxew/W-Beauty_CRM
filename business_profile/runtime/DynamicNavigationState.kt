package com.wcrm.engine.business_profile.runtime

/**
 * مدل وضعیت منوی داینامیک برنامه.
 * این کلاس پل بین Profile Runtime و لایه نمایش خواهد بود.
 */
data class DynamicNavigationState(
    val profileId: String,
    val routes: List<String>,
    val enabledModules: List<String>
)
