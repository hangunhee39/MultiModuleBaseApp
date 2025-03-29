package com.hgh.auth

import androidx.lifecycle.viewModelScope
import com.hgh.datastore.source.JWTDataSource
import com.hgh.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel  @Inject constructor(
    private val jwtDataStore: JWTDataSource,
) : BaseViewModel<LoginContract.LoginViewState, LoginContract.LoginSidEffect, LoginContract.LoginEvent>(
    LoginContract.LoginViewState()
) {
    override fun handleEvents(event:LoginContract.LoginEvent) {
        when(event){
            LoginContract.LoginEvent.OnClickLogin -> login()
        }
    }

    private fun login() = viewModelScope.launch {
        jwtDataStore.updateAccessToken("hgh")
    }
}