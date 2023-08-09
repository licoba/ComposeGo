package com.licoba.composego.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

interface Dimensions {
    val paddingTooSmall: Dp
    val paddingExtraSmall: Dp
    val paddingSmall: Dp
    val paddingNormal: Dp
    val paddingLarge: Dp
    val paddingExtraLarge: Dp
    val normalButtonHeight: Dp
    val minButtonWidth: Dp
}

val normalDimensions: Dimensions = object : Dimensions {
    override val paddingTooSmall: Dp
        get() = 2.dp
    override val paddingExtraSmall: Dp
        get() = 4.dp
    override val paddingSmall: Dp
        get() = 8.dp
    override val paddingNormal: Dp
        get() = 16.dp
    override val paddingLarge: Dp
        get() = 24.dp
    override val paddingExtraLarge: Dp
        get() = 32.dp
    override val normalButtonHeight: Dp
        get() = 56.dp
    override val minButtonWidth: Dp
        get() = 120.dp
}

// 创建全局的 Dimensions 对象
val LocalAppDimens = staticCompositionLocalOf {
    normalDimensions
}


val dimens: Dimensions
    @Composable
    get() = LocalAppDimens.current