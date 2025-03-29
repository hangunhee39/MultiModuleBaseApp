package com.hgh.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appg.setting.navigation.settingNavGraph
import com.appg.user.navigation.userNavGraph
import com.hgh.auth.navigation.authNavGraph
import com.hgh.home.navigation.homeNavGraph
import com.hgh.main.SplashScreen
import com.hgh.main.navigation.MainNavigator
import com.hgh.main.navigation.MainTab
import com.hgh.navigation.Route

@Composable
internal fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    padding: PaddingValues,
    onChangeDarkMode: (Boolean) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceDim)
    ) {
        NavHost(
            navController = navigator.navController,
            startDestination = navigator.startDestination,
        ) {
            composable<Route.Splash> {
                SplashScreen(
                    navigateAuth = { navigator.navigateAuth() },
                    navigateHome = { navigator.navigateSplashToHome() }
                )
            }

            homeNavGraph(
                padding = padding,
                onClickDetail = {
//                    navigator.navigateSession()
                },
            )

            userNavGraph(
                padding = padding,
                onClickSetting = { navigator.navigateSetting(it) }
            )

            authNavGraph(
                padding = padding,
                onClickHome = { navigator.navigate(MainTab.HOME) },
                onClickSignup = navigator::navigateSignup,
                onClickBack = navigator::popBackStackIfNotHome,
            )

            settingNavGraph(
                padding = padding,
                onClickBack = navigator::popBackStackIfNotHome,
                onClickLogout = navigator::navigateSplash,
                onChangeDarkMode = onChangeDarkMode
            )
//
//            bookmarkNavGraph(
//                onShowErrorSnackBar = onShowErrorSnackBar
//            )
//
//            contributorNavGraph(
//                onBackClick = navigator::popBackStackIfNotHome,
//                onShowErrorSnackBar = onShowErrorSnackBar
//            )
        }
    }
}
