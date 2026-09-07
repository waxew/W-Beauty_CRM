package com.wbeauty.crm.feature.customer

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CustomerScreen(
    viewModel: CustomerViewModel = hiltViewModel()
) {
    Text(text = "لیست مشتریان")
}
