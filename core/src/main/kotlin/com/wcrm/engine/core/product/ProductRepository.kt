package com.wcrm.engine.core.product

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/** قرارداد دامنه محصولات. */
interface ProductRepository {
    fun observeProducts(): Flow<List<Product>>
    fun searchProducts(query: String): Flow<List<Product>>
    suspend fun getProduct(id: Long): Product?
    suspend fun addProduct(product: Product): Long
    suspend fun updateProduct(product: Product)
    suspend fun deleteProduct(id: Long)
}

/** پیاده‌سازی Room برای Repository محصول. */
@Singleton
class ProductRepositoryImpl @Inject constructor(
    private val dao: ProductDao
) : ProductRepository {
    override fun observeProducts(): Flow<List<Product>> = dao.observeAll().map { list -> list.map(ProductEntity::toDomain) }
    override fun searchProducts(query: String): Flow<List<Product>> = dao.search(query.trim()).map { list -> list.map(ProductEntity::toDomain) }
    override suspend fun getProduct(id: Long): Product? = dao.getById(id)?.toDomain()
    override suspend fun addProduct(product: Product): Long = dao.insert(product.toEntity())
    override suspend fun updateProduct(product: Product) = dao.update(product.copy(updatedAt = System.currentTimeMillis()).toEntity())
    override suspend fun deleteProduct(id: Long) = dao.deleteById(id)
}
