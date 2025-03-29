package com.hgh.main

import android.util.Log
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hgh.main.component.MainBottomBar
import com.hgh.main.component.MainNavHost
import com.hgh.main.navigation.MainNavigator
import com.hgh.main.navigation.MainTab
import com.hgh.main.navigation.rememberMainNavigator
import kotlinx.collections.immutable.toPersistentList

@Composable
internal fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
    onChangeDarkMode: (Boolean) -> Unit,
){
    Scaffold(
        modifier = Modifier,
        content = { padding ->
            MainNavHost(
                navigator = navigator,
                padding = padding,
                onChangeDarkMode = onChangeDarkMode,
            )
        },
        bottomBar = {
            MainBottomBar(
                modifier = Modifier
                    .navigationBarsPadding(),
                visible = navigator.shouldShowBottomBar(),
                tabs = MainTab.entries.toPersistentList(),
                currentTab = navigator.currentTab,
                onTabSelected = { navigator.navigate(it) }
            )
        },
    )
}
