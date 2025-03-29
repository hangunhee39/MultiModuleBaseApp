package com.appg.user

import com.hgh.ui.base.LoadState
import com.hgh.ui.base.ViewEvent
import com.hgh.ui.base.ViewSideEffect
import com.hgh.ui.base.ViewState

class UserContract {

    data class UserViewState (
        val loadState: LoadState = LoadState.LOADING,
    ) : ViewState

    sealed class UserSidEffect: ViewSideEffect {}

    sealed class UserEvent: ViewEvent {}
}