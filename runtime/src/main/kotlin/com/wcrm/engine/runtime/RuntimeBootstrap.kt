package com.wcrm.engine.runtime.shared

import com.wcrm.engine.businessprofile.BusinessProfileRegistry

/**
 * نقطه شروع Runtime.
 * پروفایل فعال را از Registry می‌گیرد و Context معتبر برای UI/Featureها می‌سازد.
 */
class RuntimeBootstrap(
    private val registry: RuntimeRegistry = RuntimeRegistry()
) {
    fun initialize(): RuntimeContext {
        val profile = BusinessProfileRegistry.activeProfile()
        return RuntimeContext(
            profile = profile,
            enabledModules = registry.modules()
        )
    }
}
