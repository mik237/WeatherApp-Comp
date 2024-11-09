package me.ibrahim.weatherapp_comp.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.ibrahim.weatherapp_comp.R
import me.ibrahim.weatherapp_comp.main_screen.chance_of_rain_ui.ChanceOfRainUI
import me.ibrahim.weatherapp_comp.main_screen.daily_forecast_ui.DayForecastUI
import me.ibrahim.weatherapp_comp.main_screen.hourly_forecast_ui.HourlyForecastUI

@Composable
fun DailyWeatherUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_wind_speed, R.string.wind_speed, "12km/h", "2 km/h")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_rain_chance, R.string.rain_chance, "24%", "10%")
        }

        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_pressure, R.string.pressure, "720hpa", "32 hpa")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_uv_index, R.string.uv_index, "2,3", "0.3")
        }

        HourlyForecastUI()
        DayForecastUI()
        ChanceOfRainUI()
        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunrise, R.string.sunrise, "4:20 AM", "4h ago")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunset, R.string.sunset, "6:50 PM", "in 9h")
        }

    }
}

