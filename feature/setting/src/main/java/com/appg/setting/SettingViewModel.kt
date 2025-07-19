package com.appg.setting

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.hgh.datastore.source.JWTDataSource
import com.hgh.navigation.Route
import com.hgh.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val jwtDataStore: JWTDataSource
) : BaseViewModel<SettingContract.SettingViewState, SettingContract.SettingSidEffect, SettingContract.SettingEvent>(
    SettingContract.SettingViewState()
) {
    private val id = savedStateHandle.toRoute<Route.Setting>().id

    init {
        Log.d("TAG", "$id")
    }

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