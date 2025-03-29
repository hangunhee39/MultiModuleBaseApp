package com.hgh.main.navigation

import androidx.compose.runtime.Composable
import com.hgh.navigation.MainTabRoute
import com.hgh.navigation.Route

internal enum class MainTab(
    val iconResId: Int,
    internal val contentDescription: String,
    val route: MainTabRoute,
) {
    HOME(
        iconResId = android.R.drawable.ic_menu_call,
        contentDescription = "홈",
        MainTabRoute.Home
    ),
    USER(
        iconResId = android.R.drawable.ic_menu_camera,
        contentDescription = "북마크",
        MainTabRoute.User,
    );

    companion object {
        @Composable
        fun find(predicate: @Composable (MainTabRoute) -> Boolean): MainTab? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}