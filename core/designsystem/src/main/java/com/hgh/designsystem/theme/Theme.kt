package com.hgh.designsystem.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.glance.GlanceTheme
import androidx.glance.color.ColorProvider
import androidx.glance.color.colorProviders

private val LightColorScheme = lightColorScheme(
    primary = SkyBlue,
    onPrimary = PureWhite,
    primaryContainer = PureWhite,
    onPrimaryContainer = SkyBlue,
    inversePrimary = SkyBlue,
    secondary = SkyBlue,
    onSecondary = PureWhite,
    secondaryContainer = LightGray,
    onSecondaryContainer = SkyBlue,
    tertiary = SkyBlue,
    onTertiary = PureWhite,
    tertiaryContainer = LightGray,
    onTertiaryContainer = SkyBlue,
    error = LightRed,
    onError = PureWhite,
    errorContainer = ErrorContainerRed,
    onErrorContainer = DeepRed,
    surface = PureWhite,
    onSurface = VeryDarkGray,
    onSurfaceVariant = DarkGray,
    surfaceDim = LightGray,
    surfaceContainerHigh = LightSkyBlue,
    inverseSurface = SkyBlue,
    inverseOnSurface = PureWhite,
    outline = LightSkyBlue,
    outlineVariant = SkyBlue,
    scrim = ScrimDark
)

private val DarkColorScheme = darkColorScheme(
    primary = DeepRed,
    onPrimary = PureWhite,
    primaryContainer = DarkRed,
    onPrimaryContainer = PureWhite,
    inversePrimary = DeepRed,
    secondary = DeepRed,
    onSecondary = PureWhite,
    secondaryContainer = DeeperRed,
    onSecondaryContainer = PureWhite,
    tertiary = DeepRed,
    onTertiary = PureWhite,
    tertiaryContainer = DarkestRed,
    onTertiaryContainer = PureWhite,
    error = LightRed,
    onError = PureWhite,
    errorContainer = DarkErrorContainer,
    onErrorContainer = PureWhite,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    onSurfaceVariant = MidGray,
    surfaceDim = DarkSurface,
    surfaceContainerHigh = DarkSurfaceContainer,
    inverseSurface = DeepRed,
    inverseOnSurface = PureWhite,
    outline = OutlineRed,
    outlineVariant = OutlineVariantRed,
    scrim = ScrimLight
)

val LocalDarkTheme = compositionLocalOf { true }

@Composable
fun BaseTheme(
    darkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkMode) DarkColorScheme else LightColorScheme

    if (!LocalInspectionMode.current) {
        val view = LocalView.current
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkMode
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars =
                !darkMode
        }
    }

    CompositionLocalProvider(
        LocalDarkTheme provides darkMode,
        LocalTypography provides Typography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}

object BaseTheme {
    val typography: BaseTypography
        @Composable
        get() = LocalTypography.current
}

private val WidgetColorProviers = colorProviders(
    primary = ColorProvider(LightColorScheme.primary, DarkColorScheme.primary),
    onPrimary = ColorProvider(LightColorScheme.onPrimary, DarkColorScheme.onPrimary),
    primaryContainer = ColorProvider(
        LightColorScheme.primaryContainer,
        DarkColorScheme.primaryContainer
    ),
    onPrimaryContainer = ColorProvider(
        LightColorScheme.onPrimaryContainer,
        DarkColorScheme.onPrimaryContainer
    ),
    inversePrimary = ColorProvider(LightColorScheme.inversePrimary, DarkColorScheme.inversePrimary),
    secondary = ColorProvider(LightColorScheme.secondary, DarkColorScheme.secondary),
    onSecondary = ColorProvider(LightColorScheme.onSecondary, DarkColorScheme.onSecondary),
    secondaryContainer = ColorProvider(
        LightColorScheme.secondaryContainer,
        DarkColorScheme.secondaryContainer
    ),
    onSecondaryContainer = ColorProvider(
        LightColorScheme.onSecondaryContainer,
        DarkColorScheme.onSecondaryContainer
    ),
    tertiary = ColorProvider(LightColorScheme.tertiary, DarkColorScheme.tertiary),
    onTertiary = ColorProvider(LightColorScheme.onTertiary, DarkColorScheme.onTertiary),
    tertiaryContainer = ColorProvider(
        LightColorScheme.tertiaryContainer,
        DarkColorScheme.tertiaryContainer
    ),
    onTertiaryContainer = ColorProvider(
        LightColorScheme.onTertiaryContainer,
        DarkColorScheme.onTertiaryContainer
    ),
    error = ColorProvider(LightColorScheme.error, DarkColorScheme.error),
    onError = ColorProvider(LightColorScheme.onError, DarkColorScheme.onError),
    errorContainer = ColorProvider(LightColorScheme.errorContainer, DarkColorScheme.errorContainer),
    onErrorContainer = ColorProvider(
        LightColorScheme.onErrorContainer,
        DarkColorScheme.onErrorContainer
    ),
    surface = ColorProvider(LightColorScheme.surface, DarkColorScheme.surface),
    onSurface = ColorProvider(LightColorScheme.onSurface, DarkColorScheme.onSurface),
    inverseSurface = ColorProvider(LightColorScheme.inverseSurface, DarkColorScheme.inverseSurface),
    inverseOnSurface = ColorProvider(
        LightColorScheme.inverseOnSurface,
        DarkColorScheme.inverseOnSurface
    ),
    outline = ColorProvider(LightColorScheme.outline, DarkColorScheme.outline),
    background = ColorProvider(LightColorScheme.background, DarkColorScheme.background),
    onBackground = ColorProvider(LightColorScheme.onBackground, DarkColorScheme.onBackground),
    surfaceVariant = ColorProvider(LightColorScheme.surfaceVariant, DarkColorScheme.surfaceVariant),
    onSurfaceVariant = ColorProvider(
        LightColorScheme.onSurfaceVariant,
        DarkColorScheme.onSurfaceVariant
    )
)

@Composable
fun BaseGlanceTheme(
    content: @Composable () -> Unit,
) {
    GlanceTheme(
        colors = WidgetColorProviers,
        content = content
    )
}
