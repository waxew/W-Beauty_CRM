package runtime

/**
 * Registry مسئول نگهداری ماژول های قابل فعال سازی در CRM است.
 *
 * این لایه فقط Mapping انجام می دهد و نباید شامل منطق کسب و کار باشد.
 * فعال یا غیرفعال شدن قابلیت ها از Business Profile کنترل می شود.
 */
object ModuleRegistry {

    private val modules = setOf(
        "customer",
        "product",
        "inventory",
        "sales",
        "invoice",
        "warranty",
        "repair",
        "accounting",
        "delivery"
    )

    fun exists(moduleId: String): Boolean {
        return modules.contains(moduleId)
    }

    fun all(): Set<String> {
        return modules
    }
}
