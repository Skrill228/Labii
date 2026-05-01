package com.example.labii

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass

const val EXPANDED_HORIZONTAL_PADDING = 48
const val MEDIUM_HORIZONTAL_PADDING = 24
const val COMPACT_HORIZONTAL_PADDING = 8

fun Modifier.adaptiveHorizontalPadding(
    windowSizeClass: WindowSizeClass
): Modifier {
    val padding = when {
        windowSizeClass.isWidthAtLeastBreakpoint(
            WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND
        ) -> EXPANDED_HORIZONTAL_PADDING

        windowSizeClass.isWidthAtLeastBreakpoint(
            WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND
        ) -> MEDIUM_HORIZONTAL_PADDING

        else -> COMPACT_HORIZONTAL_PADDING
    }

    return this.padding(horizontal = padding.dp)
}