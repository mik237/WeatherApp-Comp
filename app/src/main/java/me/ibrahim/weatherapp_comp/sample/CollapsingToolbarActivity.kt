package me.ibrahim.weatherapp_comp.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.ibrahim.weatherapp_comp.ui.theme.WeatherAppCompTheme

class CollapsingToolbarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppCompTheme {
                ToolBarLazyExample()
            }
        }
    }
}

