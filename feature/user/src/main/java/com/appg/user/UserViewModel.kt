package com.appg.user

import com.hgh.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
) : BaseViewModel<UserContract.UserViewState, UserContract.UserSidEffect, UserContract.UserEvent>(
    UserContract.UserViewState()
) {
    override fun handleEvents(event: UserContract.UserEvent) {

    }
}