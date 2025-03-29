package com.hgh.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hgh.designsystem.theme.BaseTheme
import com.hgh.main.navigation.MainNavigator
import com.hgh.main.navigation.rememberMainNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val isDarkMode by viewModel.isDarkMode.collectAsStateWithLifecycle(false, this)
            val navigator: MainNavigator = rememberMainNavigator()

            BaseTheme(darkMode = isDarkMode) {
                MainScreen(
                    navigator = navigator,
                    onChangeDarkMode = { isDarkMode -> viewModel.updateDarkMode(isDarkMode) }
                )
            }
        }
    }
}
