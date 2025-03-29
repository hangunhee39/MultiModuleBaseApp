package com.hgh.auth.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hgh.auth.LoginScreen
import com.hgh.auth.SignupScreen
import com.hgh.navigation.Route

fun NavController.navigateAuth() {
    navigate(Route.Login) { popUpTo(Route.Splash) { inclusive = true } }
}

fun NavController.navigateSignup() {
    navigate(Route.Signup)
}

fun NavGraphBuilder.authNavGraph(
    padding: PaddingValues,
    onClickHome: () -> Unit,
    onClickSignup: () -> Unit,
    onClickBack: () -> Unit,
) {
    composable<Route.Login> {
        LoginScreen(padding = padding, onClickHome = onClickHome, onClickSignup = onClickSignup)
    }

    composable<Route.Signup> {
        SignupScreen(padding, onClickBack)
    }
}