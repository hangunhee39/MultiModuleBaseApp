package com.hgh.ui.component.type

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hgh.mmt.core.ui.R

enum class AppBarMenu(
    val padding: Dp,
    @DrawableRes val icon: Int,
    val contentDescription: String,
) {
    BACK(
        padding = 16.dp,
        icon = R.drawable.ic_back,
        contentDescription = "BACK",
    ),
    MENU(
        padding = 16.dp,
        icon = R.drawable.ic_menu,
        contentDescription = "MENU",
    ),
}
