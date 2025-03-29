package com.hgh.auth

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hgh.ui.ext.noRippleClickable
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
internal fun LoginScreen(
    padding: PaddingValues,
    onClickHome: () -> Unit,
    onClickSignup: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel()
) {
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

    Column(
        Modifier.padding(padding)
    ) {
        Spacer(Modifier.height(16.dp))
        Text("로그인", fontSize = 30.sp, modifier = Modifier.noRippleClickable{
            viewModel.setEvent(LoginContract.LoginEvent.OnClickLogin)
            onClickHome()
        })
        Spacer(Modifier.height(32.dp))
        Text("회원가입", fontSize = 30.sp, modifier = Modifier.noRippleClickable(onClickSignup))
    }
}