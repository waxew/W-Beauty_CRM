package com.wcrm.engine.runtime.di

import com.wcrm.engine.runtime.RuntimeBootstrap
import com.wcrm.engine.runtime.RuntimeContext
import com.wcrm.engine.runtime.RuntimeRegistry
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
    fun provideRuntimeContext(): RuntimeContext = RuntimeContext()

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
