package com.hgh.home

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hgh.ui.component.AppBar
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
internal fun HomeRoute(
    padding: PaddingValues,
    onClickDetail: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val viewState by viewModel.viewState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    var backPressedOnce by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    var resetJob by remember { mutableStateOf<Job?>(null) }

    BackHandler {
        if (backPressedOnce) {
            (context as? Activity)?.finishAffinity()
        } else {
            backPressedOnce = true
            Toast.makeText(context, "한 번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
            resetJob?.cancel()
            resetJob = coroutineScope.launch {
                delay(2000L)
                backPressedOnce = false
            }
        }
    }

    HomeScreen(
        padding = padding,
        viewState = viewState,
        onClickDetail = onClickDetail
    )
}

@Composable
private fun HomeScreen(
    padding: PaddingValues,
    viewState: HomeContract.HomeViewState,
    onClickDetail: () -> Unit,
) {

    Column(
        Modifier.padding(padding)
    ) {
        AppBar(title = "HOME", onClickLeft = {}, onClickRight = {})
        Text("HOME", fontSize = 30.sp)
    }
}

@Preview
@Composable
private fun PreviewHome() {
    HomeScreen(
        padding = PaddingValues(),
        viewState = HomeContract.HomeViewState(),
        onClickDetail = {}
    )
}