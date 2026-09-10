package com.wcrm.engine.core.product

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<List<Product>> = repository.observeProducts()
}

class SearchProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(query: String): Flow<List<Product>> = repository.searchProducts(query)
}

class AddProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(product: Product): Long {
        require(product.name.isNotBlank()) { "نام محصول نمی‌تواند خالی باشد." }
        require(product.price >= 0) { "قیمت محصول نمی‌تواند منفی باشد." }
        return repository.addProduct(product)
    }
}

class UpdateProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(product: Product) {
        require(product.id > 0) { "شناسه محصول برای ویرایش معتبر نیست." }
        require(product.name.isNotBlank()) { "نام محصول نمی‌تواند خالی باشد." }
        repository.updateProduct(product)
    }
}

class DeleteProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(id: Long) {
        require(id > 0) { "شناسه محصول برای حذف معتبر نیست." }
        repository.deleteProduct(id)
    }
}
