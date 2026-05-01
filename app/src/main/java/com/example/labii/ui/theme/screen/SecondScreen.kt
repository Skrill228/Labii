package com.example.labii.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.labii.adaptiveHorizontalPadding
import com.example.labii.component.SecondComponent

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3AdaptiveApi::class
)
@Composable
fun SecondScreen(component: SecondComponent) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Второй экран")
                }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .adaptiveHorizontalPadding(
                    currentWindowAdaptiveInfo().windowSizeClass
                )
        ) {
            SelectionContainer {
                Text(component.param)
            }
        }
    }
}
