package com.wcrm.engine.runtime

import com.wcrm.engine.businessprofile.BusinessProfile
import com.wcrm.engine.businessprofile.FeatureFlag
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Creates the initial runtime state of the application.
 */
@Singleton
class RuntimeInitializer @Inject constructor(
    private val businessRegistry: BusinessRegistry
) {
    fun initialize(): RuntimeContext {
        val profile = resolveDefaultProfile()

        return RuntimeContext(
            profile = profile,
            enabledFeatures = profile.features.toSet()
        )
    }

    private fun resolveDefaultProfile(): BusinessProfile {
        return businessRegistry.getDefaultProfile()
    }
}
