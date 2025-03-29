package com.hgh.datastore.source

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.hgh.datastore.source.JWTDataSourceImpl.Companion.ACCESS_TOKEN_KEY
import com.hgh.datastore.source.JWTDataSourceImpl.Companion.REFRESH_TOKEN_KEY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

class SettingDataSourceImpl @Inject constructor(
    @Named("setting") private val dataStore: DataStore<Preferences>,
) : SettingDataSource {
    companion object {
        val IS_DARK_MADE = booleanPreferencesKey("IS_DARK_MODE")
    }

    override val isDarkMode = dataStore.data.map { pf ->
        pf[IS_DARK_MADE] ?: false
    }

    override suspend fun updateDarkMode(isDark: Boolean) {
        dataStore.edit { pf ->
            pf[IS_DARK_MADE] = isDark
        }
    }
}
