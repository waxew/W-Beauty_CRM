package com.wcrm.engine.business_profile.runtime

/**
 * Provider ساده برای تولید وضعیت Navigation بر اساس Profile فعال.
 * این لایه واسط بین Runtime Profile و Navigation UI است.
 */
class DynamicNavigationProvider(
    private val resolver: ProfileRouteResolver
) {

    fun provide(profileId: String): DynamicNavigationState {
        val routes = resolver.resolveRoutes(profileId)
        return DynamicNavigationState(
            activeProfileId = profileId,
            routes = routes,
            enabledModules = routes.map { it.moduleId }.distinct()
        )
    }
}
