package com.hgh.ui.ext

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun Float.toFixedSp(): TextUnit {
    val density = LocalDensity.current
    return with(density) { this@toFixedSp / density.fontScale }.sp
}