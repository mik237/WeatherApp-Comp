package me.ibrahim.weatherapp_comp.main_screen.ten_days_ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import me.ibrahim.weatherapp_comp.R
import me.ibrahim.weatherapp_comp.ui.theme.Purple80
import me.ibrahim.weatherapp_comp.utils.Utils

@Composable
fun DayWeatherForcastUI(
    timestamp: Long,
    weatherStatus: String,
    maxTemp: Int,
    minTemp: Int,
    @DrawableRes icon: Int
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 5.dp)
            .background(Color(0xffEBDEFF), shape = RoundedCornerShape(18.dp))
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(14.dp)
        ) {
            val (time, weather, temperatureColumn, divider, weatherIcon) = createRefs()

            Text(text = Utils.timestampToDay(timestamp),
                color = Color.Black,
                fontSize = 16.sp,
                modifier = Modifier.constrainAs(time) {
                    top.linkTo(parent.top)
                    bottom.linkTo(weather.top, margin = 14.dp)
                    start.linkTo(parent.start)
                    end.linkTo(temperatureColumn.start, margin = 5.dp)
                    width = Dimension.fillToConstraints
                }
            )

            Text(text = weatherStatus,
                color = Color.Gray,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.constrainAs(weather) {
                    top.linkTo(time.bottom)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(time.end)
                    width = Dimension.fillToConstraints
                }
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .constrainAs(temperatureColumn) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(divider.start, margin = 10.dp)
                    }) {
                Text(
                    text = "$maxTemp°",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xff2E004E),
                    modifier = Modifier
                )
                Text(
                    text = "$minTemp°",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xff2E004E),
                    modifier = Modifier
                )
            }

            VerticalDivider(
                color = Color.Black,
                modifier = Modifier
                    .height(42.dp)
                    .constrainAs(divider) {
                        top.linkTo(time.top)
                        bottom.linkTo(weather.bottom)
                        end.linkTo(weatherIcon.start, margin = 10.dp)
                    })

            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(54.dp)
                    .constrainAs(weatherIcon) {
                        top.linkTo(time.top)
                        bottom.linkTo(weather.bottom)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}


@Preview
@Composable
private fun DayWeatherForcastUIPreview() {

    DayWeatherForcastUI(
        System.currentTimeMillis(),
        "Cloudy",
        maxTemp = 15,
        minTemp = 7,
        icon = R.drawable.cloud_and_sun
    )
}