package com.hgh.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    private const val JWT_DATASTORE_NAME = "JWT_DATASTORE"

    private val Context.JWTDataStore by preferencesDataStore(JWT_DATASTORE_NAME)

    private const val SETTING_DATASTORE_NAME = "SETTING_DATASTORE"

    private val Context.SettingDataStore by preferencesDataStore(SETTING_DATASTORE_NAME)

    @Provides
    @Singleton
    @Named("jwt")
    fun provideJWTDataStore(
        @ApplicationContext context: Context,
    ): DataStore<Preferences> =
        context.JWTDataStore

    @Provides
    @Singleton
    @Named("setting")
    fun provideSettingDataStore(
        @ApplicationContext context: Context,
    ): DataStore<Preferences> =
        context.SettingDataStore
}
