package com.asteam.wcrm.business_profile.runtime

/**
 * مبدل وضعیت Runtime به داده قابل مصرف برای لایه نمایش
 * این کلاس فقط مسئول تبدیل داده است و منطق UI داخل آن قرار نمی‌گیرد.
 */
object DynamicNavigationMapper {

    fun map(
        state: DynamicNavigationState
    ): List<NavigationDestination> {
        return state.routes.map { route ->
            NavigationDestination(
                route = route,
                enabled = true
            )
        }
    }
}

/**
 * مدل ساده مسیر قابل استفاده توسط Navigation Layer
 */
data class NavigationDestination(
    val route: String,
    val enabled: Boolean
)
