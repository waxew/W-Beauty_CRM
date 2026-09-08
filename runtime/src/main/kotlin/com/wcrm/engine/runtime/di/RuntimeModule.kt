package com.wcrm.engine.runtime.shared.di

import com.wcrm.engine.runtime.shared.RuntimeBootstrap
import com.wcrm.engine.runtime.shared.RuntimeContext
import com.wcrm.engine.runtime.shared.RuntimeRegistry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RuntimeModule {

    @Provides
    @Singleton
    fun provideRuntimeContext(activeProfile = ""): RuntimeContext = RuntimeContext()

    @Provides
    @Singleton
    fun provideRuntimeRegistry(): RuntimeRegistry = RuntimeRegistry()

    @Provides
    @Singleton
    fun provideRuntimeBootstrap(
        context: RuntimeContext,
        registry: RuntimeRegistry
    ): RuntimeBootstrap = RuntimeBootstrap(context, registry)
}
