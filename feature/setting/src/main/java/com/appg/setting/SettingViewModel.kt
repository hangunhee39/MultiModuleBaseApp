package com.appg.setting

import androidx.lifecycle.viewModelScope
import com.hgh.datastore.source.JWTDataSource
import com.hgh.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val jwtDataStore: JWTDataSource
) : BaseViewModel<SettingContract.SettingViewState, SettingContract.SettingSidEffect, SettingContract.SettingEvent>(
    SettingContract.SettingViewState()
) {
    override fun handleEvents(event: SettingContract.SettingEvent) {
        when(event) {
            SettingContract.SettingEvent.OnClickLogout -> {
               logout()
            }
        }
    }

    private fun logout() = viewModelScope.launch {
        jwtDataStore.updateAccessToken("")
        jwtDataStore.updateRefreshToken("")
    }
}