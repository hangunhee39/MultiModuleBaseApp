package com.hgh.auth

import com.hgh.ui.base.LoadState
import com.hgh.ui.base.ViewEvent
import com.hgh.ui.base.ViewSideEffect
import com.hgh.ui.base.ViewState

class SignupContract {

    data class SignupViewState (
        val loadState: LoadState = LoadState.LOADING,
    ) : ViewState

    sealed class SignupSidEffect: ViewSideEffect {}

    sealed class SignupEvent: ViewEvent {}
}