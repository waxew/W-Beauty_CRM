package core.inventory

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InventoryHiltModule {

    @Provides
    @Singleton
    fun provideInventoryRepository(
        impl: InventoryRepositoryImpl
    ): InventoryRepository {
        return impl
    }
}
