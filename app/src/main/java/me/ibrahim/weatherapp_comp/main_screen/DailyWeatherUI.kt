package me.ibrahim.weatherapp_comp.main_screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import me.ibrahim.weatherapp_comp.R

@Composable
fun DailyWeatherUI(scrollState: ScrollState) {
    Column(
        modifier = Modifier
            .layoutId("box")
            .verticalScroll(scrollState)
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

        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunrise, R.string.sunrise, "4:20 AM", "4h ago")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunset, R.string.sunset, "6:50 PM", "in 9h")
        }

        /*************************/
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

        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunrise, R.string.sunrise, "4:20 AM", "4h ago")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunset, R.string.sunset, "6:50 PM", "in 9h")
        }
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

        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunrise, R.string.sunrise, "4:20 AM", "4h ago")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunset, R.string.sunset, "6:50 PM", "in 9h")
        }
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

        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunrise, R.string.sunrise, "4:20 AM", "4h ago")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunset, R.string.sunset, "6:50 PM", "in 9h")
        }
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

        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunrise, R.string.sunrise, "4:20 AM", "4h ago")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunset, R.string.sunset, "6:50 PM", "in 9h")
        }
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

        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunrise, R.string.sunrise, "4:20 AM", "4h ago")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunset, R.string.sunset, "6:50 PM", "in 9h")
        }
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

        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunrise, R.string.sunrise, "4:20 AM", "4h ago")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunset, R.string.sunset, "6:50 PM", "in 9h")
        }
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

        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunrise, R.string.sunrise, "4:20 AM", "4h ago")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunset, R.string.sunset, "6:50 PM", "in 9h")
        }
    }
}