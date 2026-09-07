package com.wcrm.engine.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

private const val HOME_ROUTE = "home"

@Composable
fun AppNavigation(
    routes: List<RouteDefinition> = emptyList()
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE
    ) {
        composable(HOME_ROUTE) {
            // Core home container.
        }

        routes.forEach { route ->
            composable(route.route) {
                // Feature destination is provided by runtime feature module.
            }
        }
    }
}
