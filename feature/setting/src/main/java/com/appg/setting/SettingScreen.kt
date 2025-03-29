package com.appg.setting

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
import androidx.hilt.navigation.compose.hiltViewModel
import com.hgh.designsystem.theme.LocalDarkTheme
import com.hgh.ui.component.AppBar
import com.hgh.ui.component.type.AppBarMenu
import com.hgh.ui.ext.noRippleClickable


@Composable
internal fun SettingScreen(
    id: String,
    padding: PaddingValues,
    onClickBack: () -> Unit,
    onClickLogout: () -> Unit,
    onChangeDarkMode: (Boolean) -> Unit,
    viewModel: SettingViewModel = hiltViewModel()
) {
    Column(
        Modifier.padding(padding)
    ) {
        AppBar(
            title = "설정",
            left = AppBarMenu.BACK,
            onClickLeft = onClickBack,
            onClickRight = {})
        Text(id, fontSize = 30.sp)
        Text("로그아웃", fontSize = 30.sp,
            modifier = Modifier.noRippleClickable {
                viewModel.setEvent(SettingContract.SettingEvent.OnClickLogout)
                onClickLogout()
            })
        Spacer(Modifier.height(50.dp))
        DarkModeText(onChangeDarkMode = onChangeDarkMode)
    }
}

@Composable
internal fun DarkModeText(
    darkMode: Boolean = LocalDarkTheme.current,
    onChangeDarkMode: (Boolean) -> Unit,
) {
    Text(
        text = if (darkMode) "다크모드" else "라이트모드",
        fontSize = 30.sp,
        modifier = Modifier.noRippleClickable {
            onChangeDarkMode(darkMode.not())
        })
}