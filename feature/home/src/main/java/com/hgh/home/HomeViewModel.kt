package com.hgh.home

import com.hgh.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : BaseViewModel<HomeContract.HomeViewState, HomeContract.HomeSidEffect, HomeContract.HomeEvent>(
    HomeContract.HomeViewState()
) {
    override fun handleEvents(event: HomeContract.HomeEvent) {

    }
}