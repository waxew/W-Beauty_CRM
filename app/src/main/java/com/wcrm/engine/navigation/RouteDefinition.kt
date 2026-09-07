package com.wcrm.engine.navigation

/**
 * Runtime navigation route definition.
 * Features register routes without coupling navigation to business profiles.
 */
data class RouteDefinition(
    val id: String,
    val route: String
)
