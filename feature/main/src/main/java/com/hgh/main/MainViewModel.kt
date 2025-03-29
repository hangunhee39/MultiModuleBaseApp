package com.hgh.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgh.datastore.source.SettingDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val settingDataSource: SettingDataSource
) : ViewModel() {
    val isDarkMode = settingDataSource.isDarkMode

    fun updateDarkMode(isDarkMode: Boolean) = viewModelScope.launch {
        settingDataSource.updateDarkMode(isDarkMode)
    }
}