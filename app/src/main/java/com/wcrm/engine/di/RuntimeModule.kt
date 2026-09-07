package com.wcrm.engine.di

import com.wcrm.engine.navigation.RouteRegistry
import com.wcrm.engine.navigation.RuntimeNavigationResolver
import com.wcrm.engine.runtime.FeatureRuntimeLoader
import com.wcrm.engine.runtime.RuntimeFeatureResolver
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
    fun provideRuntimeFeatureResolver(): RuntimeFeatureResolver {
        return RuntimeFeatureResolver()
    }

    @Provides
    @Singleton
    fun provideFeatureRuntimeLoader(): FeatureRuntimeLoader {
        return FeatureRuntimeLoader()
    }

    @Provides
    @Singleton
    fun provideRouteRegistry(): RouteRegistry {
        return RouteRegistry()
    }

    @Provides
    @Singleton
    fun provideRuntimeNavigationResolver(): RuntimeNavigationResolver {
        return RuntimeNavigationResolver()
    }
}
