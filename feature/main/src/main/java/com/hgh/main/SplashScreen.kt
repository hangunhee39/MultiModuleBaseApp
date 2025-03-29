package com.hgh.main

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navigateAuth: () -> Unit,
    navigateHome: () -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val visibleState = remember { MutableTransitionState(true) }.apply { targetState = true }

    LaunchedEffect(Unit) {
        Log.d("HGH", "visibleState - ${visibleState.targetState}")
        delay(1_000L)
        visibleState.targetState = false
        delay(500L)
        Log.d("HGH", "isAuthLogin - ${viewModel.isAuthLogin.value}")
        if (viewModel.isAuthLogin.value) {
            navigateHome()
        } else {
            navigateAuth()
        }
    }

    AnimatedVisibility(
        visibleState = visibleState,
        exit = fadeOut(animationSpec = tween(500)) + scaleOut(targetScale = 0.9f, animationSpec = tween(500))
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Splash")
        }
    }
}