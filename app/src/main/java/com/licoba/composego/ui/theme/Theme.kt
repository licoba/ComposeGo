package com.licoba.composego.ui.theme

import android.app.Activity
import android.os.Build
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


/**
 * Light default theme color scheme
 */
@VisibleForTesting
val LightColors = lightColorScheme(
    primary = Purple40,  // 主要颜色，通常用于突出重要的界面元素，如按钮、选中状态等。
    onPrimary = Color.White,  // 在按钮上的文本或图标的颜色。
    primaryContainer = Purple90, //  主要容器颜色，用于表示主要颜色的容器，如卡片、对话框等。
    onPrimaryContainer = Purple10, // 在主要容器颜色上的文本或图标的颜色。
    secondary = Orange40, // 次要颜色，通常用于辅助界面元素。
    onSecondary = Color.White, // 在次要颜色上的文本或图标的颜色。
    secondaryContainer = Gray70, //  次要容器颜色，用于表示次要颜色的容器。比如按钮不可用时的颜色
    onSecondaryContainer = Black10, // 在次要容器颜色上的文本或图标的颜色。
    tertiary = Blue40, // 第三颜色，用于辅助界面元素。
    onTertiary = Color.White, // 在第三颜色上的文本或图标的颜色。
    tertiaryContainer = Blue90, // 第三容器颜色，用于表示第三颜色的容器。
    onTertiaryContainer = Blue10, //  在第三容器颜色上的文本或图标的颜色。
    error = Red40, // 错误颜色，用于表示错误状态或错误信息。
    onError = Color.White, //  在错误颜色上的文本或图标的颜色。
    errorContainer = Red90, //  错误容器颜色，用于表示错误颜色的容器。
    onErrorContainer = Red10, //  在错误容器颜色上的文本或图标的颜色。
    background = DarkPurpleGray99, // 背景颜色，用于界面的背景。
    onBackground = DarkPurpleGray10, // 在背景颜色上的文本或图标的颜色。
    surface = DarkPurpleGray99, // 表面颜色，用于表示界面上的表面元素，如卡片、对话框等。
    onSurface = DarkPurpleGray10, //  在表面颜色上的文本或图标的颜色。
    surfaceVariant = PurpleGray90, // 表面变体颜色，用于表示表面元素的不同状态或变体。
    onSurfaceVariant = PurpleGray30, // 在表面变体颜色上的文本或图标的颜色。
    outline = PurpleGray50 //  轮廓颜色，用于表示界面元素的轮廓或边框颜色。
)

/**
 * Dark default theme color scheme
 */
@VisibleForTesting
val DarkColors = darkColorScheme(
    primary = Purple80,
    onPrimary = Purple20,
    primaryContainer = Purple30,
    onPrimaryContainer = Purple90,
    secondary = Orange80,
    onSecondary = Orange20,
    secondaryContainer = Orange30,
    onSecondaryContainer = Orange90,
    tertiary = Blue80,
    onTertiary = Blue20,
    tertiaryContainer = Blue30,
    onTertiaryContainer = Blue90,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = DarkPurpleGray10,
    onBackground = DarkPurpleGray90,
    surface = DarkPurpleGray10,
    onSurface = DarkPurpleGray90,
    surfaceVariant = PurpleGray30,
    onSurfaceVariant = PurpleGray80,
    outline = PurpleGray60
)

@Composable
fun AppTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightColors
    } else {
        DarkColors
    }

    val dimens: Dimensions = staticCompositionLocalOf {
        normalDimensions
    }.current

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content
    )
}
