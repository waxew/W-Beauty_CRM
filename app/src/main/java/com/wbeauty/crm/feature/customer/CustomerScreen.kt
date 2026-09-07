package com.wbeauty.crm.feature.customer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CustomerScreen(
    onAddCustomer: () -> Unit,
    viewModel: CustomerViewModel = hiltViewModel()
) {
    val customers by viewModel.customers.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "لیست مشتریان")

        Button(onClick = onAddCustomer) {
            Text(text = "افزودن مشتری")
        }

        LazyColumn {
            items(customers) { customer ->
                Text(
                    text = customer.name,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}
