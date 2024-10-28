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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
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
                        val density = LocalDensity.current

                        val progress by remember {
                            derivedStateOf {
                                val currentScroll = scrollState.value
                                val headerHeightPx = with(density) { 400.dp.toPx() }

                                val progress = if (currentScroll > headerHeightPx) {
                                    1f
                                } else if (currentScroll < headerHeightPx) {
                                    currentScroll.toFloat() / headerHeightPx
                                } else 0f
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




