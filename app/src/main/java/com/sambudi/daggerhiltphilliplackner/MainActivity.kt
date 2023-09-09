package com.sambudi.daggerhiltphilliplackner

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.direku.cuanamansambilrebahan.data.source.responsestatus.Status
import com.sambudi.daggerhiltphilliplackner.ui.theme.DaggerHiltPhillipLacknerTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@AndroidEntryPoint // Dibutuhkan karena kita mengInject activity ini
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltPhillipLacknerTheme {
                var finalResult by rememberSaveable { mutableStateOf("Initial") }

                Greeting(finalResult)

                val viewModel = hiltViewModel<MyViewModel>()
                runBlocking {
                    withContext(Dispatchers.Main) {
                        viewModel.hitMyApiWithFlow()
                    }
                }

                viewModel.result.observe(this) { result ->
                    when (result.status) {
                        Status.STATUS_API_LOADING -> {
                            Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT)
                                .show()
                        }

                        Status.STATUS_API_FAILURE -> {
                            Toast.makeText(this, "${result.throwable?.message}", Toast.LENGTH_SHORT)
                                .show()
                        }

                        Status.STATUS_API_SUCCESS -> {
                            Toast.makeText(this, "sukses", Toast.LENGTH_SHORT).show()
                            finalResult = result.body.toString() + " <-- ok"
                        }

                        else -> {}
                    }
                }

            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DaggerHiltPhillipLacknerTheme {
        Greeting("Android")
    }
}
