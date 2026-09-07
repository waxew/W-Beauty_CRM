package com.wcrm.engine.navigation

/**
 * Resolves navigation routes provided by active runtime features.
 */
class RuntimeNavigationResolver(
    private val routes: List<RouteDefinition>
) {
    fun activeRoutes(): List<RouteDefinition> = routes
}
