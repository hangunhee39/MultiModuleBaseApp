package com.appg.setting

import com.hgh.ui.base.LoadState
import com.hgh.ui.base.ViewEvent
import com.hgh.ui.base.ViewSideEffect
import com.hgh.ui.base.ViewState

class SettingContract {

    data class SettingViewState(
        val loadState: LoadState = LoadState.LOADING,
    ) : ViewState

    sealed class SettingSidEffect : ViewSideEffect {}

    sealed class SettingEvent : ViewEvent {
         object OnClickLogout : SettingEvent()
    }
}