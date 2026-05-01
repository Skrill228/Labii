package com.example.labii.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteItem
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.window.core.layout.WindowSizeClass
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.example.labii.component.Config
import com.example.labii.component.RootComponent
import com.example.labii.ui.theme.screen.AboutScreen
import com.example.labii.ui.theme.screen.HomeScreen
import com.example.labii.ui.theme.screen.SecondScreen

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        val adaptiveInfo = currentWindowAdaptiveInfo()
        val windowSizeClass = adaptiveInfo.windowSizeClass

        val navigationSuiteType = when {
            windowSizeClass.isWidthAtLeastBreakpoint(
                WindowSizeClass.WIDTH_DP_EXPANDED_LOWER_BOUND
            ) -> NavigationSuiteType.WideNavigationRailExpanded

            windowSizeClass.isWidthAtLeastBreakpoint(
                WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND
            ) -> NavigationSuiteType.WideNavigationRailCollapsed

            else -> NavigationSuiteType.ShortNavigationBarCompact
        }

        val navigationScaffoldState = rememberNavigationSuiteScaffoldState()
        val childStack by rootComponent.childStack.subscribeAsState()

        LaunchedEffect(childStack.active.configuration) {
            if (childStack.active.configuration is Config.MainScreen) {
                navigationScaffoldState.show()
            } else {
                navigationScaffoldState.hide()
            }
        }

        NavigationSuiteScaffold(
            navigationSuiteType = navigationSuiteType,
            state = navigationScaffoldState,
            navigationItems = {
                NavigationSuiteItem(
                    selected = childStack.active.configuration == Config.Home,
                    onClick = { rootComponent.navigate(Config.Home) },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text("Главная")
                    },
                    navigationSuiteType = navigationSuiteType
                )

                NavigationSuiteItem(
                    selected = childStack.active.configuration == Config.About,
                    onClick = { rootComponent.navigate(Config.About) },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null
                        )
                    },
                    label = {
                        Text("О программе")
                    },
                    navigationSuiteType = navigationSuiteType
                )
            }
        ) {
            Children(
                stack = rootComponent.childStack,
                animation = stackAnimation(fade())
            ) {
                when (val child = it.instance) {
                    is RootComponent.Child.Home -> {
                        HomeScreen(child.component)
                    }

                    is RootComponent.Child.Second -> {
                        SecondScreen(child.component)
                    }

                    is RootComponent.Child.About -> {
                        AboutScreen(child.component)
                    }
                }
            }
        }
    }
}
