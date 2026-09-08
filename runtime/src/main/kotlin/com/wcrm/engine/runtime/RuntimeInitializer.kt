package com.wcrm.engine.runtime

class RuntimeInitializer {

    fun initialize(profile: String): RuntimeContext {
        return RuntimeBootstrap.initialize(profile)
    }
}
