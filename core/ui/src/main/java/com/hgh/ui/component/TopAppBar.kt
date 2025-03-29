package com.hgh.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hgh.designsystem.theme.BaseTheme
import com.hgh.designsystem.theme.Gray80
import com.hgh.designsystem.theme.Gray90
import com.hgh.designsystem.theme.White
import com.hgh.ui.component.type.AppBarMenu
import com.hgh.ui.ext.noRippleClickable

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String = "",
    left: AppBarMenu? = null,
    right: AppBarMenu? = null,
    onClickLeft: () -> Unit,
    onClickRight: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            //.background(White)
    ) {

        if (title.isNotEmpty()) {
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                textAlign = TextAlign.Center,
                style = BaseTheme.typography.labelMediumR,
                //color = Gray80,
                maxLines = 1,
            )
        }

        if (left != null) {
            Icon(
                imageVector = ImageVector.vectorResource(id = left.icon),
                //tint = Gray90,
                contentDescription = left.contentDescription,
                modifier = Modifier
                    .padding(start = left.padding)
                    .clip(RoundedCornerShape(30.dp))
                    .noRippleClickable { onClickLeft() }
                    .align(Alignment.CenterStart),
            )
        }
        if (right != null) {
            Icon(
                imageVector = ImageVector.vectorResource(id = right.icon),
                //tint = Gray90,
                contentDescription = right.contentDescription,
                modifier = Modifier
                    .padding(end = right.padding)
                    .clip(RoundedCornerShape(30.dp))
                    .noRippleClickable { onClickRight() }
                    .align(Alignment.CenterEnd),
            )
        }
    }
}
