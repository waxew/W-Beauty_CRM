package com.wcrm.engine.runtime

import com.wcrm.engine.businessprofile.BusinessProfile
import com.wcrm.engine.businessprofile.FeatureFlag

/**
 * Active application runtime context.
 * Holds selected business profile and enabled capabilities.
 */
data class RuntimeContext(
    val profile: BusinessProfile,
    val enabledFeatures: Set<FeatureFlag>
)
