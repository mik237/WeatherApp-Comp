package me.ibrahim.weatherapp_comp.main_screen.daily_forecast_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.weatherapp_comp.R
import me.ibrahim.weatherapp_comp.ui.theme.Purple80

@Composable
fun DayForecastUI() {
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
                    painter = painterResource(id = R.drawable.icon_day_forecast),
                    contentDescription = null
                )

                Text(
                    text = stringResource(id = R.string.day_forecast),
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }


            val temperaturePoints = listOf(
                Point(0f, 7f), // Mon
                Point(1f, 26f), // Tue
                Point(2f, 35f), // Wed
                Point(3f, 22f), // Thu
                Point(4f, 27f), // Fri
                Point(5f, 18f), // Sat
                Point(6f, 24f)  // Sun
            )
            GPTLineChart(
                points = temperaturePoints,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                lineColor = Color.Black,
                gradientColor = Color.Black,
                pointColor = Color.Black
            )
        }
    }
}