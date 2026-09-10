package com.wcrm.engine.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wcrm.engine.core.product.AddProductUseCase
import com.wcrm.engine.core.product.DeleteProductUseCase
import com.wcrm.engine.core.product.ObserveProductsUseCase
import com.wcrm.engine.core.product.Product
import com.wcrm.engine.core.product.SearchProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/** ViewModel واقعی محصولات متصل به Room از مسیر UseCase. */
@HiltViewModel
class ProductViewModel @Inject constructor(
    observeProducts: ObserveProductsUseCase,
    searchProducts: SearchProductsUseCase,
    private val addProduct: AddProductUseCase,
    private val deleteProduct: DeleteProductUseCase
) : ViewModel() {

    val query = MutableStateFlow("")
    val error = MutableStateFlow<String?>(null)

    @OptIn(ExperimentalCoroutinesApi::class)
    val products: StateFlow<List<Product>> = query
        .flatMapLatest { value ->
            if (value.isBlank()) observeProducts() else searchProducts(value)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())

    fun setQuery(value: String) {
        query.value = value
    }

    fun add(name: String, price: Long) {
        viewModelScope.launch {
            runCatching {
                addProduct(Product(name = name.trim(), price = price))
            }.onSuccess {
                error.value = null
            }.onFailure {
                error.value = it.message ?: "خطا در ثبت محصول"
            }
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch {
            runCatching { deleteProduct(id) }
                .onFailure { error.value = it.message ?: "خطا در حذف محصول" }
        }
    }
}
