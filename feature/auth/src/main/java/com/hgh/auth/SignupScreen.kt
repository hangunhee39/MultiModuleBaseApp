package com.hgh.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hgh.ui.component.AppBar
import com.hgh.ui.component.type.AppBarMenu

@Composable
internal fun SignupScreen(
    padding: PaddingValues,
    onClickBack: () -> Unit
) {
    Column(
        Modifier.padding(padding)
    ) {
        AppBar(title = "회원가입", left = AppBarMenu.BACK, onClickLeft = onClickBack, onClickRight = {})
        Spacer(Modifier.height(16.dp))
        Text("회원가입", fontSize = 30.sp)
    }
}