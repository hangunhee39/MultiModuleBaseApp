package com.hgh.datastore.source

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

class JWTDataSourceImpl @Inject constructor(
    @Named("jwt") private val dataStore: DataStore<Preferences>,
) : JWTDataSource {
    companion object {
        val ACCESS_TOKEN_KEY = stringPreferencesKey("ACCESS_TOKEN")
        val REFRESH_TOKEN_KEY = stringPreferencesKey("REFRESH_TOKEN")
    }

    override val accessToken = dataStore.data.map { preferences ->
        preferences[ACCESS_TOKEN_KEY]
    }

    override suspend fun updateAccessToken(assessToken: String) {
        dataStore.edit { preferences ->
            preferences[ACCESS_TOKEN_KEY] = assessToken
        }
    }

    override val refreshToken = dataStore.data.map { preferences ->
        preferences[REFRESH_TOKEN_KEY]
    }

    override suspend fun updateRefreshToken(refreshToken: String) {
        dataStore.edit { preferences ->
            preferences[REFRESH_TOKEN_KEY] = refreshToken
        }
    }
}
