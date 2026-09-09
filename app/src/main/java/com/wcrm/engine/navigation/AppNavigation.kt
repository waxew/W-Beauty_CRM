package com.wcrm.engine.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wbeauty.crm.feature.customer.CustomerAddScreen
import com.wbeauty.crm.feature.customer.CustomerRoutes
import com.wbeauty.crm.feature.customer.CustomerScreen
import com.wcrm.engine.businessprofile.BusinessProfileCatalog
import com.wcrm.engine.businessprofile.BusinessUiConfig
import com.wcrm.engine.businessprofile.DashboardItemConfig

private const val HOME_ROUTE = "home"

/**
 * ناوبری اصلی برنامه CRM.
 *
 * UI از Business Profile فعال خوانده می‌شود. در نتیجه با تغییر enabled بین ده Profile،
 * عنوان صفحه خانه، کارت‌های داشبورد، واژگان و مقصدهای نمایشی نیز تغییر می‌کنند.
 */
@Composable
fun AppNavigation(
    routes: List<RouteDefinition> = emptyList()
) {
    val navController = rememberNavController()
    val activeProfile = BusinessProfileCatalog.requireActiveProfile()
    val uiConfig = requireNotNull(activeProfile.ui) {
        "Business Profile فعال باید uiConfig داشته باشد: ${activeProfile.id}"
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        NavHost(
            navController = navController,
            startDestination = HOME_ROUTE
        ) {
            composable(HOME_ROUTE) {
                HomeScreen(
                    uiConfig = uiConfig,
                    onDashboardItemClick = { item ->
                        when (item.route) {
                            CustomerRoutes.LIST -> navController.navigate(CustomerRoutes.LIST)
                            else -> navController.navigate(item.route)
                        }
                    }
                )
            }

            composable(CustomerRoutes.LIST) {
                CustomerScreen(
                    onAddCustomer = {
                        navController.navigate(CustomerRoutes.ADD)
                    }
                )
            }

            composable(CustomerRoutes.ADD) {
                CustomerAddScreen(
                    onSaved = {
                        navController.popBackStack(CustomerRoutes.LIST, inclusive = false)
                    }
                )
            }

            // تمام Routeهای داشبورد Profile فعال ثبت می‌شوند تا UI با صنف انتخابی هماهنگ باشد.
            uiConfig.dashboardItems
                .map { it.route }
                .distinct()
                .filter { it != CustomerRoutes.LIST && it != CustomerRoutes.ADD && it != HOME_ROUTE }
                .forEach { route ->
                    composable(route) {
                        ProfileFeatureScreen(
                            uiConfig = uiConfig,
                            item = uiConfig.dashboardItems.first { it.route == route }
                        )
                    }
                }

            // Routeهای Runtime خارجی نیز حفظ می‌شوند و با Routeهای Profile تداخل نمی‌کنند.
            routes
                .filter { route ->
                    route.route != HOME_ROUTE &&
                        route.route != CustomerRoutes.LIST &&
                        route.route != CustomerRoutes.ADD &&
                        uiConfig.dashboardItems.none { it.route == route.route }
                }
                .forEach { route ->
                    composable(route.route) {
                        RuntimeFeatureScreen(route = route)
                    }
                }
        }
    }
}

/**
 * داشبورد Profile-aware.
 * این Screen برای هر ده کسب‌وکار مشترک است، اما محتوا و کارت‌ها از Profile فعال می‌آیند.
 */
@Composable
private fun HomeScreen(
    uiConfig: BusinessUiConfig,
    onDashboardItemClick: (DashboardItemConfig) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = uiConfig.homeTitle,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = uiConfig.homeSubtitle,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(24.dp))

            uiConfig.dashboardItems.forEach { item ->
                Button(
                    onClick = { onDashboardItemClick(item) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(item.title)
                }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

/**
 * صفحه موقتِ Profile-aware برای ماژول‌هایی که Backend اختصاصی آن‌ها هنوز تکمیل نشده است.
 * این صفحه عمداً اطلاعات Profile را نمایش می‌دهد تا هیچ Route به صفحه سفید ختم نشود؛
 * در مراحل بعد با Screen/ViewModel/UseCase/Repository واقعی هر ماژول جایگزین می‌شود.
 */
@Composable
private fun ProfileFeatureScreen(
    uiConfig: BusinessUiConfig,
    item: DashboardItemConfig
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "ظاهر فعال: ${uiConfig.themeId}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "مجموعه تصویر: ${uiConfig.illustrationSetId}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/** مقصد عمومی برای Routeهایی که مستقل از Business Profile از Runtime ثبت می‌شوند. */
@Composable
private fun RuntimeFeatureScreen(route: RouteDefinition) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = "ماژول فعال",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = route.route,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
