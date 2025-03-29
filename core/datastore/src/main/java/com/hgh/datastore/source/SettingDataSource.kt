package com.hgh.datastore.source

import kotlinx.coroutines.flow.Flow

interface SettingDataSource {
    val isDarkMode: Flow<Boolean>
    suspend fun updateDarkMode(isDark: Boolean)
}