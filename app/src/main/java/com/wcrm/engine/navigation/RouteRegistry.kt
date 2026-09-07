package com.wcrm.engine.navigation

import com.wcrm.engine.feature.FeatureModule

class RouteRegistry(
    private val features: List<FeatureModule>
) {
    fun availableRoutes(): List<String> =
        features.filter { it.isEnabled() }.map { it.id }
}
