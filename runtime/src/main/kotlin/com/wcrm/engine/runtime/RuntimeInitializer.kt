package com.wcrm.engine.runtime

class RuntimeInitializer(
    private val bootstrap: RuntimeBootstrap
) {

    fun initialize(profile: String): RuntimeContext {
        return bootstrap.initialize(profile)
    }
}
