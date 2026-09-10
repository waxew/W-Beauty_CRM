package com.wcrm.engine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wcrm.engine.customer.CustomerViewModel
import com.wcrm.engine.product.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Activity اصلی برنامه.
 * این UI عمداً ساده و عملکردی است؛ طراحی نهایی بعداً انجام می‌شود، اما تمام عملیات این صفحه به Backend واقعی متصل است.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                WCrmFunctionalApp()
            }
        }
    }
}

private enum class AppSection { HOME, CUSTOMERS, PRODUCTS }

@Composable
private fun WCrmFunctionalApp() {
    var section by remember { mutableStateOf(AppSection.HOME) }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("W-CRM", style = MaterialTheme.typography.headlineMedium)

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { section = AppSection.HOME }) { Text("خانه") }
                Button(onClick = { section = AppSection.CUSTOMERS }) { Text("مشتریان") }
                Button(onClick = { section = AppSection.PRODUCTS }) { Text("محصولات") }
            }

            when (section) {
                AppSection.HOME -> HomeContent()
                AppSection.CUSTOMERS -> CustomerContent()
                AppSection.PRODUCTS -> ProductContent()
            }
        }
    }
}

@Composable
private fun HomeContent() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("داشبورد عملیاتی", style = MaterialTheme.typography.titleLarge)
        Text("Customer و Product اکنون از UI تا Room Database متصل هستند.")
        Text("طراحی نهایی، منوی Profile-driven و سایر ماژول‌ها در مراحل بعدی روی همین معماری اضافه می‌شوند.")
    }
}

@Composable
private fun CustomerContent(viewModel: CustomerViewModel = hiltViewModel()) {
    val customers by viewModel.customers.collectAsStateWithLifecycle()
    val query by viewModel.query.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("مدیریت مشتریان", style = MaterialTheme.typography.titleLarge)
        OutlinedTextField(
            value = query,
            onValueChange = viewModel::setQuery,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("جستجو با نام یا شماره") }
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("نام مشتری") }
        )
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("شماره تماس") }
        )
        Button(
            onClick = {
                viewModel.add(name, phone)
                name = ""
                phone = ""
            }
        ) { Text("ثبت مشتری") }

        error?.let { Text(it, color = MaterialTheme.colorScheme.error) }

        LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            items(customers, key = { it.id }) { customer ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(customer.name)
                            Text(customer.phone)
                        }
                        TextButton(onClick = { viewModel.delete(customer.id) }) {
                            Text("حذف")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ProductContent(viewModel: ProductViewModel = hiltViewModel()) {
    val products by viewModel.products.collectAsStateWithLifecycle()
    val query by viewModel.query.collectAsStateWithLifecycle()
    val error by viewModel.error.collectAsStateWithLifecycle()
    var name by remember { mutableStateOf("") }
    var priceText by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("مدیریت محصولات", style = MaterialTheme.typography.titleLarge)
        OutlinedTextField(
            value = query,
            onValueChange = viewModel::setQuery,
            modifier = Modifier.fillMaxWidth(),
            label = { Text("جستجوی محصول") }
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("نام محصول") }
        )
        OutlinedTextField(
            value = priceText,
            onValueChange = { priceText = it.filter(Char::isDigit) },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("قیمت") }
        )
        Button(
            onClick = {
                viewModel.add(name, priceText.toLongOrNull() ?: 0L)
                name = ""
                priceText = ""
            }
        ) { Text("ثبت محصول") }

        error?.let { Text(it, color = MaterialTheme.colorScheme.error) }

        LazyColumn(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            items(products, key = { it.id }) { product ->
                Card(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(product.name)
                            Text("قیمت: ${product.price}")
                        }
                        TextButton(onClick = { viewModel.delete(product.id) }) {
                            Text("حذف")
                        }
                    }
                }
            }
        }
    }
}
