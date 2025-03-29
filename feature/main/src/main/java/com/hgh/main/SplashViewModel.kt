package com.hgh.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hgh.datastore.source.JWTDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor (
    private val jwtDataStore: JWTDataSource
) : ViewModel() {

    val isAuthLogin: StateFlow<Boolean> = jwtDataStore.accessToken
        .map { it.isNullOrEmpty().not() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, false)

    init {
        viewModelScope.launch {
            Log.d("HGH", "jwt - ${jwtDataStore.accessToken.first()}")
        }
    }
}