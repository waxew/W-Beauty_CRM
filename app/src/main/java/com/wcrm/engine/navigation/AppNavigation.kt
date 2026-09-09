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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wbeauty.crm.feature.customer.CustomerAddScreen
import com.wbeauty.crm.feature.customer.CustomerRoutes
import com.wbeauty.crm.feature.customer.CustomerScreen
import com.wcrm.engine.businessprofile.BusinessUiConfig
import com.wcrm.engine.businessprofile.DashboardItemConfig
import com.wcrm.engine.businessprofile.ProfileRegistry

private const val HOME_ROUTE = "home"

/**
 * ناوبری اصلی برنامه CRM.
 *
 * Profile فعال دیگر از یک لیست Hardcode خوانده نمی‌شود. Registry در زمان اجرا
 * تمام فایل‌های assets/business_profiles را کشف می‌کند و تنها Profile فعال را
 * در اختیار UI قرار می‌دهد.
 */
@Composable
fun AppNavigation(
    routes: List<RouteDefinition> = emptyList()
) {
    val context = LocalContext.current.applicationContext
    val navController = rememberNavController()
    val profileRegistry = remember(context) { ProfileRegistry.fromAssets(context) }
    val activeProfile = remember(profileRegistry) { profileRegistry.requireSingleEnabled() }
    val uiConfig = requireNotNull(activeProfile.ui) {
        "Business Profile فعال باید uiConfig داشته باشد: ${activeProfile.id}"
    }

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        NavHost(navController = navController, startDestination = HOME_ROUTE) {
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
                CustomerScreen(onAddCustomer = { navController.navigate(CustomerRoutes.ADD) })
            }

            composable(CustomerRoutes.ADD) {
                CustomerAddScreen(
                    onSaved = { navController.popBackStack(CustomerRoutes.LIST, inclusive = false) }
                )
            }

            // Routeهای داشبورد بدون شناخت نوع کسب‌وکار از Profile فعال ساخته می‌شوند.
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

            routes
                .filter { route ->
                    route.route != HOME_ROUTE &&
                        route.route != CustomerRoutes.LIST &&
                        route.route != CustomerRoutes.ADD &&
                        uiConfig.dashboardItems.none { it.route == route.route }
                }
                .forEach { route ->
                    composable(route.route) { RuntimeFeatureScreen(route) }
                }
        }
    }
}

/** داشبورد عمومی که تمام محتوا و ترتیب کارت‌ها را از Profile فعال می‌گیرد. */
@Composable
private fun HomeScreen(
    uiConfig: BusinessUiConfig,
    onDashboardItemClick: (DashboardItemConfig) -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(
            modifier = Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(uiConfig.homeTitle, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(uiConfig.homeSubtitle, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(24.dp))
            uiConfig.dashboardItems.forEach { item ->
                Button(
                    onClick = { onDashboardItemClick(item) },
                    modifier = Modifier.fillMaxWidth()
                ) { Text(item.title) }
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

/**
 * مقصد موقت ماژول‌هایی که Backend کامل آن‌ها هنوز ساخته نشده است.
 * این صفحه در مرحله تکمیل هر Feature با Screen واقعی جایگزین می‌شود.
 */
@Composable
private fun ProfileFeatureScreen(uiConfig: BusinessUiConfig, item: DashboardItemConfig) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
            Text(item.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text("ظاهر فعال: ${uiConfig.themeId}", style = MaterialTheme.typography.bodyMedium)
            Text("مجموعه تصویر: ${uiConfig.illustrationSetId}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
private fun RuntimeFeatureScreen(route: RouteDefinition) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
            Text("ماژول فعال", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(route.route, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
