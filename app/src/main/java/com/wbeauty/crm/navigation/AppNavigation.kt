package com.wbeauty.crm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wbeauty.crm.feature.customer.CustomerAddScreen
import com.wbeauty.crm.feature.customer.CustomerScreen

private const val CUSTOMER_LIST = "customers"
private const val CUSTOMER_ADD = "customers/add"

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CUSTOMER_LIST
    ) {
        composable(CUSTOMER_LIST) {
            CustomerScreen(
                onAddCustomer = {
                    navController.navigate(CUSTOMER_ADD)
                }
            )
        }

        composable(CUSTOMER_ADD) {
            CustomerAddScreen(
                onSaved = {
                    navController.popBackStack()
                }
            )
        }
    }
}
