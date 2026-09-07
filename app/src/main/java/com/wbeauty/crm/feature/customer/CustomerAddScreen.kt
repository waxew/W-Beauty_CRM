package com.wbeauty.crm.feature.customer

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CustomerAddScreen(
    onSaved: () -> Unit,
    viewModel: CustomerViewModel = hiltViewModel()
) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    val saveState by viewModel.saveState.collectAsState()

    Column {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("نام مشتری") }
        )

        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("شماره تماس") }
        )

        Button(
            onClick = {
                viewModel.addCustomer(name, phone)
            }
        ) {
            Text("ذخیره")
        }

        when (saveState) {
            CustomerSaveResult.Success -> onSaved()
            is CustomerSaveResult.Error -> Text("خطا در ذخیره مشتری")
            CustomerSaveResult.Idle -> {}
        }
    }
}
