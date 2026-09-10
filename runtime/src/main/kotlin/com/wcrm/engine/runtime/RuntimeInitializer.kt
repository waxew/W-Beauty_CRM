package com.wcrm.engine.runtime.shared

/** Facade ساده برای راه‌اندازی Runtime فعال برنامه. */
class RuntimeInitializer(
    private val bootstrap: RuntimeBootstrap = RuntimeBootstrap()
) {
    fun initialize(): RuntimeContext = bootstrap.initialize()
}
