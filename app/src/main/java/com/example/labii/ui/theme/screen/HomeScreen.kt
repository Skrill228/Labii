package com.example.labii.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.labii.adaptiveHorizontalPadding
import com.example.labii.component.HomeComponent

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalMaterial3AdaptiveApi::class
)
@Composable
fun HomeScreen(component: HomeComponent) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Домашний экран")
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
            var text by remember { mutableStateOf("") }

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = {
                    Text("Параметр второго экрана")
                }
            )

            Button(
                onClick = {
                    component.navigateToSecondScreen(text)
                }
            ) {
                Text("Перейти на второй экран")
            }
        }
    }
}