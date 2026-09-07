package com.wcrm.engine.runtime

class RuntimeModuleRegistry {
    private val modules = mutableSetOf<String>()

    fun register(module: String) {
        modules.add(module)
    }

    fun isEnabled(module: String): Boolean {
        return modules.contains(module)
    }

    fun enabledModules(): Set<String> = modules.toSet()
}
