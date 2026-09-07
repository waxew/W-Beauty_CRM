package com.wcrm.engine.runtime

import com.wcrm.engine.businessprofile.FeatureFlag

/**
 * Runtime decision layer for enabling application modules.
 * Business type must not be hard coded here.
 */
class ModuleActivation {

    fun isEnabled(
        enabledFeatures: Set<FeatureFlag>,
        feature: FeatureFlag
    ): Boolean {
        return enabledFeatures.contains(feature)
    }

    fun resolveEnabledModules(
        enabledFeatures: Set<FeatureFlag>
    ): Set<FeatureFlag> {
        return enabledFeatures
    }
}
