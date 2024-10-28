package me.ibrahim.weatherapp_comp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import me.ibrahim.weatherapp_comp.main_screen.WeatherMainUI
import me.ibrahim.weatherapp_comp.ui.theme.WeatherAppCompTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppCompTheme {
                Scaffold { _ ->
                    Column(
                        modifier = Modifier
//                            .padding(it)
                            .fillMaxSize()
                    ) {
                        val scrollState = rememberScrollState()

                        val progress by remember {
                            derivedStateOf {
                                val currentScroll = scrollState.value
                                val maxScroll = scrollState.maxValue
                                val headerHeight = 400

                                val progress = if (currentScroll > headerHeight) {
                                    1f
                                } else if (currentScroll in 1..headerHeight) {
                                    currentScroll.toFloat() / headerHeight
                                } else 0f

                                /*val clampedScroll = currentScroll.coerceIn(0, headerHeight)
                                val progress = clampedScroll /headerHeight.toFloat()*/

                                Log.d(
                                    "derivedStateOf",
                                    "currentScroll: $currentScroll, maxScroll:$maxScroll, headerHeight:$headerHeight, progress:$progress"
                                )
                                progress
                            }
                        }
                        WeatherMainUI(progress = progress, scrollState)
                    }
                }
            }
        }
    }
}




