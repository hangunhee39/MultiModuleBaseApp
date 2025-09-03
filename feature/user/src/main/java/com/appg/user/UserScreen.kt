package com.appg.user

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hgh.ui.component.AppBar
import com.hgh.ui.ext.noRippleClickable

@Composable
fun UserScreen(
    padding: PaddingValues,
    onSettingClick: (String) -> Unit,
    result: String?,
    viewModel: UserViewModel = hiltViewModel()
) {
    LaunchedEffect(result) {
        if (result != null) {
            Log.d("HGHLOG", "LaunchedEffect call $result")
            viewModel.handleEvents(UserContract.UserEvent.ReturnSettingValue(result ))
        }
    }


    Column(
        Modifier.padding(padding)
    ) {
        AppBar(title = "USER", onClickRight = {}, onClickLeft = {})
        Text("HGH", fontSize = 30.sp)
        Text("설정으로", fontSize = 30.sp, modifier = Modifier.noRippleClickable { onSettingClick("HGH") })
    }
}
