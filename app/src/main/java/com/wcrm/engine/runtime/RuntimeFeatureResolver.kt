package com.wcrm.engine.runtime

import com.wcrm.engine.feature.FeatureModule

class RuntimeFeatureResolver {
    fun resolve(activeFeatures: List<FeatureModule>): List<FeatureModule> =
        activeFeatures.filter { it.isEnabled() }
}
