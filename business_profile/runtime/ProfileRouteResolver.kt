package com.wcrm.engine.business_profile.runtime

/**
 * مسئول تبدیل ماژول‌های فعال یک Business Profile به Route های قابل استفاده در UI.
 *
 * این لایه فعلاً فقط Resolver است و UI نهایی در مرحله Navigation Compose متصل می‌شود.
 */
class ProfileRouteResolver {

    fun resolveRoutes(
        modules: Set<String>
    ): List<String> {
        return modules.mapNotNull { module ->
            when (module) {
                "Customer" -> "customers"
                "Product" -> "products"
                "Inventory" -> "inventory"
                "Sales" -> "sales"
                "Invoice" -> "invoice"
                "Warranty" -> "warranty"
                "Repair" -> "repair"
                "Accounting" -> "accounting"
                "Delivery" -> "delivery"
                else -> null
            }
        }
    }
}
