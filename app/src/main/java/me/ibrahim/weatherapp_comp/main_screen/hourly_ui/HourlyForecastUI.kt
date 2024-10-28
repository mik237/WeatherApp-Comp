package me.ibrahim.weatherapp_comp.main_screen.hourly_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import me.ibrahim.weatherapp_comp.ui.theme.Purple80

@Preview
@Composable
fun HourlyForecastUI() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 5.dp)
            .background(Purple80, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Image(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(id = R.drawable.icon_hourly_forecase),
                    contentDescription = null
                )

                Text(
                    text = stringResource(id = R.string.hourly_forecase),
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(hourlyForecasts, key = {
                    it.time
                }) {
                    HourlyForecast(time = it.time, icon = it.icon, temp = it.temp)
                }
            }
        }
    }
}

@Composable
fun HourlyForecast(
    time: String,
    icon: Int,
    temp: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = time,
            fontSize = 13.sp,
            color = Color.Black
        )
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(70.dp)
        )
        Text(
            text = temp,
            fontSize = 18.sp,
            color = Color.Black
        )
    }
}

val hourlyForecasts = listOf(
    HourlyForecastData(
        time = "Now",
        icon = R.drawable.cloud_and_sun,
        temp = "10\u00B0"
    ),
    HourlyForecastData(
        time = "10AM",
        icon = R.drawable.cloud_and_sun,
        temp = "10\u00B0"
    ),
    HourlyForecastData(
        time = "11AM",
        icon = R.drawable.cloud_and_sun,
        temp = "10\u00B0"
    ),
    HourlyForecastData(
        time = "12PM",
        icon = R.drawable.cloud_and_sun,
        temp = "10\u00B0"
    ),
    HourlyForecastData(
        time = "1PM",
        icon = R.drawable.cloud_and_sun,
        temp = "10\u00B0"
    ),
    HourlyForecastData(
        time = "2M",
        icon = R.drawable.cloud_and_sun,
        temp = "10\u00B0"
    ),
    HourlyForecastData(
        time = "3PM",
        icon = R.drawable.cloud_and_sun,
        temp = "10\u00B0"
    ),
)

data class HourlyForecastData(
    val time: String,
    val icon: Int,
    val temp: String
)