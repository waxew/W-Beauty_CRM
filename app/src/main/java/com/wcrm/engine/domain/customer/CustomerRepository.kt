package com.wcrm.engine.domain.customer

interface CustomerRepository {
    fun save(customer: Customer)
    fun findById(id: String): Customer?
}
