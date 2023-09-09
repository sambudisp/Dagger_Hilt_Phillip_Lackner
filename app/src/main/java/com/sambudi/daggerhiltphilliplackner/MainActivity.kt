package com.sambudi.daggerhiltphilliplackner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sambudi.daggerhiltphilliplackner.ui.theme.DaggerHiltPhillipLacknerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // Dibutuhkan karena kita mengInject activity ini
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltPhillipLacknerTheme {
                val viewModel = hiltViewModel<MyViewModel>()
            }
        }
    }
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerHiltPhillipLacknerTheme {
        Greeting("Android")
    }
}*/
