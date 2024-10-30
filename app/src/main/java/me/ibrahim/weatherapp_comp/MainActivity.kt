package me.ibrahim.weatherapp_comp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
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
                        WeatherMainUI()
                    }
                }
            }
        }
    }
}




