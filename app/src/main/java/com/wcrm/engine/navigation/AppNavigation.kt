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

private const val HOME_ROUTE = "home"

/**
 * ناوبری اصلی برنامه CRM.
 *
 * صفحه خانه دیگر یک کانتینر خالی نیست و مسیرهای واقعی ماژول مشتریان
 * به رابط کاربری متصل شده‌اند. مسیرهای Runtime نیز همچنان به صورت پویا
 * قابل اضافه شدن هستند تا معماری ماژولار پروژه حفظ شود.
 */
@Composable
fun AppNavigation(
    routes: List<RouteDefinition> = emptyList()
) {
    val navController = rememberNavController()

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        NavHost(
            navController = navController,
            startDestination = HOME_ROUTE
        ) {
            composable(HOME_ROUTE) {
                HomeScreen(
                    onCustomersClick = {
                        navController.navigate(CustomerRoutes.LIST)
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

            routes.forEach { route ->
                if (route.route != HOME_ROUTE &&
                    route.route != CustomerRoutes.LIST &&
                    route.route != CustomerRoutes.ADD
                ) {
                    composable(route.route) {
                        RuntimeFeatureScreen(route = route)
                    }
                }
            }
        }
    }
}

/**
 * داشبورد اصلی CRM.
 * این صفحه نقطه ورود قابل مشاهده و کاربردی برنامه است و به ماژول‌های واقعی وصل می‌شود.
 */
@Composable
private fun HomeScreen(
    onCustomersClick: () -> Unit
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
                text = "W-CRM",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "مدیریت ارتباط با مشتریان و کسب‌وکار",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onCustomersClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("مدیریت مشتریان")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "هسته ماژولار CRM فعال است. قابلیت‌های هر کسب‌وکار از Business Profile و Runtime بارگذاری می‌شوند.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

/**
 * مقصد عمومی برای مسیرهایی که از Runtime ثبت می‌شوند.
 * به جای صفحه کاملاً خالی، حداقل اطلاعات مسیر فعال را نمایش می‌دهد تا
 * هیچ Route قابل دسترسی به صفحه سفید منتهی نشود.
 */
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
