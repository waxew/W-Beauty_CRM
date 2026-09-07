package com.wcrm.engine.runtime

import com.wcrm.engine.feature.FeatureModule

class FeatureRuntimeLoader {

    fun loadEnabledFeatures(
        features: List<FeatureModule>
    ): List<FeatureModule> {
        return features.filter { it.isEnabled() }
    }
}
