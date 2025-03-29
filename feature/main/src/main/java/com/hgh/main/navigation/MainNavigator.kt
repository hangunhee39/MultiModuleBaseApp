package com.hgh.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.appg.setting.navigation.navigateSetting
import com.appg.user.navigation.navigateUser
import com.hgh.auth.navigation.navigateAuth
import com.hgh.auth.navigation.navigateSignup
import com.hgh.home.navigation.navigateHome
import com.hgh.navigation.MainTabRoute
import com.hgh.navigation.Route

internal class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination: Route = Route.Splash

    val currentTab: MainTab?
        @Composable get() = MainTab.find { tab ->
            currentDestination?.hasRoute(tab::class) == true
        }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(MainTabRoute.Home) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.HOME -> navController.navigateHome(navOptions)
            MainTab.USER -> navController.navigateUser(navOptions)
        }
    }

    fun navigateSplashToHome() {
        navController.popBackStack()
        navController.navigate(MainTabRoute.Home)
    }

    fun navigateAuth() {
        navController.navigateAuth()
    }

    fun navigateSplash() {
        navController.navigate(Route.Splash) { popUpTo(0) { inclusive = true } }
    }

    fun navigateSignup() {
        navController.navigateSignup()
    }


    fun navigateSetting(userId: String) {
        navController.navigateSetting(userId)
    }

    private fun popBackStack() {
        navController.popBackStack()
    }

    fun popBackStackIfNotHome() {
        if (!isSameCurrentDestination<MainTabRoute.Home>()) {
            popBackStack()
        }
    }

    private inline fun <reified T : Route> isSameCurrentDestination(): Boolean {
        return navController.currentDestination?.hasRoute<T>() == true
    }

    @Composable
    fun shouldShowBottomBar() = MainTab.contains {
        currentDestination?.hasRoute(it::class) == true
    }
}

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}
