package com.wcrm.engine.runtime.shared

class RuntimeBootstrap(
    private val context: RuntimeContext,
    private val registry: RuntimeRegistry
) {

    fun initialize(profile: String): RuntimeContext {
        return context.copy(
            activeProfile = profile,
            enabledFeatures = registry.modules()
        )
    }
}
