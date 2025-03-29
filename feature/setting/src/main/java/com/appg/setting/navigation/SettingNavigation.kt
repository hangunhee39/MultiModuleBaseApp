package com.appg.setting.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.appg.setting.SettingScreen
import com.hgh.navigation.Route

fun NavController.navigateSetting(userId: String) {
    navigate(Route.Setting(userId))
}

fun NavGraphBuilder.settingNavGraph(
    padding: PaddingValues,
    onClickBack: () -> Unit,
    onClickLogout: () -> Unit,
    onChangeDarkMode: (Boolean) -> Unit,
) {
    composable<Route.Setting> {
        val userId = it.toRoute<Route.Setting>().id
        SettingScreen(userId, padding, onClickBack, onClickLogout, onChangeDarkMode)
    }
}
