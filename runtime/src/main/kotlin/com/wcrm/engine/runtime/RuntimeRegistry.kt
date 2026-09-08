package com.wcrm.engine.runtime.shared

class RuntimeRegistry {
    private val modules = mutableSetOf<String>()

    fun register(module: String) {
        modules.add(module)
    }

    fun modules(): Set<String> = modules
}
