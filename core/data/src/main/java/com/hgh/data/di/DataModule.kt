package com.hgh.data.di

import com.hgh.datastore.source.JWTDataSource
import com.hgh.datastore.source.JWTDataSourceImpl
import com.hgh.data.remote.NoAuthService
import com.hgh.datastore.source.SettingDataSource
import com.hgh.datastore.source.SettingDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataModule {

    @Binds
    abstract fun bindSessionLocalDataSource(
        dataSource: JWTDataSourceImpl,
    ): JWTDataSource

    @Binds
    abstract fun bindSettingDataSource(
        dataSource: SettingDataSourceImpl,
    ): SettingDataSource
}

@Module
@InstallIn(SingletonComponent::class)
internal object ServiceModule {
    private inline fun <reified T> Retrofit.buildService(): T {
        return this.create(T::class.java)
    }

    @Provides
    @Singleton
    fun provideNoAuthService(
        retrofit: Retrofit
    ): NoAuthService {
        return retrofit.buildService()
    }
}

@Module
@InstallIn(ViewModelComponent::class)
internal object RepositoryModule {

}