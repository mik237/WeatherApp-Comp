package me.ibrahim.weatherapp_comp.main_screen.ten_days_ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.ibrahim.weatherapp_comp.R

@Composable
fun TenDaysWeatherUI() {
    Column(
        modifier = Modifier.wrapContentHeight()
    ) {
        MaterialTheme.shapes.medium
        tenDaysWeatherData.forEachIndexed { index, item ->
            DayWeatherForcastUI(
                item.timestamp + (index * 86400000),
                item.weatherStatus,
                maxTemp = item.maxTemp,
                minTemp = item.minTemp,
                icon = item.icon
            )
        }
    }
}


val tenDaysWeatherData = listOf(
    TenDayWeatherData(
        System.currentTimeMillis(),
        "Sunny",
        maxTemp = 39,
        minTemp = 28,
        icon = R.drawable.sunny
    ),
    TenDayWeatherData(
        System.currentTimeMillis(),
        "Cloudy",
        maxTemp = 29,
        minTemp = 19,
        icon = R.drawable.cloudy
    ),
    TenDayWeatherData(
        System.currentTimeMillis(),
        "Cloudy and Sunny",
        maxTemp = 35,
        minTemp = 27,
        icon = R.drawable.cloud_and_sun
    ),
    TenDayWeatherData(
        System.currentTimeMillis(),
        "Sunny",
        maxTemp = 39,
        minTemp = 28,
        icon = R.drawable.sunny
    ),
    TenDayWeatherData(
        System.currentTimeMillis(),
        "Cloudy",
        maxTemp = 29,
        minTemp = 19,
        icon = R.drawable.cloudy
    ),
    TenDayWeatherData(
        System.currentTimeMillis(),
        "Cloudy and Sunny",
        maxTemp = 35,
        minTemp = 27,
        icon = R.drawable.cloud_and_sun
    ),
    TenDayWeatherData(
        System.currentTimeMillis(),
        "Sunny",
        maxTemp = 39,
        minTemp = 28,
        icon = R.drawable.sunny
    ),
    TenDayWeatherData(
        System.currentTimeMillis(),
        "Cloudy",
        maxTemp = 29,
        minTemp = 19,
        icon = R.drawable.cloudy
    ),
    TenDayWeatherData(
        System.currentTimeMillis(),
        "Cloudy and Sunny",
        maxTemp = 35,
        minTemp = 27,
        icon = R.drawable.cloud_and_sun
    ),
    TenDayWeatherData(
        System.currentTimeMillis(),
        "Sunny",
        maxTemp = 39,
        minTemp = 28,
        icon = R.drawable.sunny
    )
)

data class TenDayWeatherData(
    val timestamp: Long,
    val weatherStatus: String,
    val maxTemp: Int,
    val minTemp: Int,
    @DrawableRes val icon: Int
)

