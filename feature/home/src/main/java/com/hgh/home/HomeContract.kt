package com.hgh.home

import com.hgh.ui.base.LoadState
import com.hgh.ui.base.ViewEvent
import com.hgh.ui.base.ViewSideEffect
import com.hgh.ui.base.ViewState

class HomeContract {

    data class HomeViewState (
        val loadState: LoadState = LoadState.LOADING,
    ) : ViewState

    sealed class HomeSidEffect: ViewSideEffect {}

    sealed class HomeEvent: ViewEvent {}
}