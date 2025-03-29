package com.hgh.auth

import com.hgh.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(

) : BaseViewModel<SignupContract.SignupViewState, SignupContract.SignupSidEffect, SignupContract.SignupEvent>(
    SignupContract.SignupViewState()
) {
    override fun handleEvents(event:SignupContract.SignupEvent) {

    }
}