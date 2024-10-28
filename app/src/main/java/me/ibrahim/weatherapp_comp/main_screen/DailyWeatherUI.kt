package me.ibrahim.weatherapp_comp.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.weatherapp_comp.R
import me.ibrahim.weatherapp_comp.main_screen.hourly_ui.HourlyForecastUI
import me.ibrahim.weatherapp_comp.ui.theme.Purple80

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

        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunrise, R.string.sunrise, "4:20 AM", "4h ago")
            WeatherFeatureDataUI(modifier = Modifier.weight(1f), R.drawable.icon_sunset, R.string.sunset, "6:50 PM", "in 9h")
        }

    }
}

