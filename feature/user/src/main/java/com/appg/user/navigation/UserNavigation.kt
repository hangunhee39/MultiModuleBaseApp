package com.appg.user.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.appg.user.UserScreen
import com.hgh.navigation.MainTabRoute


fun NavController.navigateUser(navOptions: NavOptions) {
    navigate(MainTabRoute.User, navOptions)
}

fun NavGraphBuilder.userNavGraph(
    padding: PaddingValues,
    onClickSetting: (String) -> Unit,
) {
    composable<MainTabRoute.User> {
        UserScreen(padding, onClickSetting)
    }
}
