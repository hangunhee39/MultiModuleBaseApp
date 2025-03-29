package com.hgh.auth

import com.hgh.ui.base.LoadState
import com.hgh.ui.base.ViewEvent
import com.hgh.ui.base.ViewSideEffect
import com.hgh.ui.base.ViewState

class LoginContract {

    data class LoginViewState (
        val loadState: LoadState = LoadState.LOADING,
    ) : ViewState

    sealed class LoginSidEffect: ViewSideEffect {}

    sealed class LoginEvent: ViewEvent {
        object OnClickLogin : LoginEvent()
    }
}