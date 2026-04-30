package com.example.labii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.labii.ui.theme.LabiiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabiiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    LabiiTheme {
        Scaffold { contentPadding ->
            var state by remember { mutableStateOf(false) }
            Column(Modifier.padding(contentPadding)) {
                Button(onClick = { state = !state }) {
                    Text("Переключить")
                }
                Text("Состояние: $state")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabiiTheme {
        App()
    }
}