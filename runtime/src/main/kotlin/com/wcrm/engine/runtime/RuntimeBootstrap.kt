package com.wcrm.engine.runtime

object RuntimeBootstrap {

    fun initialize(profile: String): RuntimeContext {
        return RuntimeContext(
            activeProfile = profile,
            enabledFeatures = emptySet()
        )
    }
}
