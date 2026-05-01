package com.example.labii.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.labii.adaptiveHorizontalPadding
import com.example.labii.component.AboutComponent

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3AdaptiveApi::class
)
@Composable
fun AboutScreen(component: AboutComponent) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("О программе")
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
            Text("Создано в рамках изучения мобильной разработки")
        }
    }
}