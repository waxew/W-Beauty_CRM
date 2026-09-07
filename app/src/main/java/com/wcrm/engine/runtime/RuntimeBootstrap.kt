package com.wcrm.engine.runtime

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Coordinates application runtime startup.
 * Keeps startup flow independent from business type.
 */
@Singleton
class RuntimeBootstrap @Inject constructor(
    private val initializer: RuntimeInitializer
) {
    fun start(): RuntimeContext {
        return initializer.initialize()
    }
}
