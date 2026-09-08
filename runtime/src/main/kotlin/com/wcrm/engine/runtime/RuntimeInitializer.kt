package com.wcrm.engine.runtime.shared

class RuntimeInitializer(
    private val bootstrap: RuntimeBootstrap
) {

    fun initialize(profile: String): RuntimeContext {
        return bootstrap.initialize(profile)
    }
}
