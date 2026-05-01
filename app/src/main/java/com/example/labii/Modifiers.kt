package com.example.labii

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass

const val EXPANDED_HORIZONTAL_PADDING =
    WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND / 4

const val COMPACT_HORIZONTAL_PADDING = 4

fun Modifier.adaptiveHorizontalPadding(
    windowWidth: Dp,
    windowSizeClass: WindowSizeClass
): Modifier {
    val paddingDp = when {
        windowSizeClass.isWidthAtLeastBreakpoint(
            WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND
        ) -> {
            EXPANDED_HORIZONTAL_PADDING.toFloat()
        }

        windowSizeClass.isWidthAtLeastBreakpoint(
            WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND
        ) -> {
            val medium = WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND.toFloat()
            val expanded = WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND.toFloat()

            val factor = ((windowWidth.value - medium) / (expanded - medium))
                .coerceIn(0f, 1f)

            COMPACT_HORIZONTAL_PADDING * (1 - factor) +
                    EXPANDED_HORIZONTAL_PADDING * factor
        }

        else -> {
            COMPACT_HORIZONTAL_PADDING.toFloat()
        }
    }

    return this.padding(horizontal = paddingDp.dp)
}