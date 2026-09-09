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
        val enabledFeatures = profile.modules.mapNotNull { moduleName ->
            runCatching { FeatureFlag.valueOf(moduleName) }.getOrNull()
        }.toSet()

        return RuntimeContext(
            profile = profile,
            enabledFeatures = enabledFeatures
        )
    }

    private fun resolveDefaultProfile(): BusinessProfile {
        return businessRegistry.getDefaultProfile()
    }
}
