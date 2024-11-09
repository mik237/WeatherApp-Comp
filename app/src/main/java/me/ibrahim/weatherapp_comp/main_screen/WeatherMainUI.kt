package me.ibrahim.weatherapp_comp.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import me.ibrahim.weatherapp_comp.R
import me.ibrahim.weatherapp_comp.ui.theme.TextColor


@OptIn(ExperimentalMotionApi::class)
@Composable
fun WeatherMainUI() {

    val outerLazyColumnScrollState = rememberLazyListState()
    val density = LocalDensity.current
    val context = LocalContext.current

    val maxPx = with(LocalDensity.current) { 412.dp.toPx() }
    val minPx = with(LocalDensity.current) { 228.dp.toPx() }
    val toolbarHeight = remember { mutableFloatStateOf(maxPx) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val height = toolbarHeight.floatValue;

                if (height + available.y > maxPx) {
                    toolbarHeight.floatValue = maxPx
                    return Offset(0f, maxPx - height)
                }

                if (height + available.y < minPx) {
                    toolbarHeight.floatValue = minPx
                    return Offset(0f, minPx - height)
                }

                toolbarHeight.floatValue += available.y
                return Offset(0f, available.y)
            }

        }
    }

    val progress = 1 - (toolbarHeight.floatValue - minPx) / (maxPx - minPx)

    /*val progress by remember {
        derivedStateOf {
            val currentScroll = scrollState.value
            val maxScroll = scrollState.maxValue
            val headerHeightPx = with(density) { 400.dp.toPx() }

            val progress = if (currentScroll > headerHeightPx) {
                1f
            } else if (currentScroll < headerHeightPx) {
                currentScroll.toFloat() / headerHeightPx
            } else 0f
            Log.d("ScrollOffset", "currentScroll: $currentScroll, maxScroll: $maxScroll, progress: $progress, heightPx: $headerHeightPx")
            progress
        }
    }*/

    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.weather_header_motion_scene)
            .readBytes()
            .decodeToString()
    }
    var selectedIndex by remember { mutableIntStateOf(0) }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF6EDFF)),
        /*debug = EnumSet.of(MotionLayoutDebugFlags.SHOW_ALL)*/
    ) {



        val imgProperties = motionProperties(id = "bg_image")
        val contentColor = motionProperties(id = "toolbar")
        val txtTemperature = motionProperties(id = "txtTemperature")

        Image(
            painter = painterResource(id = R.drawable.bg_header_img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(
                        bottomStartPercent = imgProperties.value.int("bottomStartPercent"),
                        bottomEndPercent = imgProperties.value.int("bottomEndPercent")
                    )
                )
                .layoutId("bg_image")
        )

        Box(
            modifier = Modifier
                .layoutId("bgCollapsed")
                .fillMaxWidth()
                .background(Color(0xFFE1D3FA))
        )

        Row(
            modifier = Modifier.layoutId("toolbar"),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Kharkiv, Ukraine",
                modifier = Modifier.layoutId("txtLocation"),
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
                color = contentColor.value.color("contentColor"),
            )
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .layoutId("iconSearch")
                    .size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Search, contentDescription = null,
                    tint = contentColor.value.color("contentColor"),
                )
            }
        }


        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.layoutId("txtTemperature")
        ) {
            //\u00B0
            Text(
                text = "3°",
                color = contentColor.value.color("contentColor"),
                fontSize = txtTemperature.value.int("fontSize").sp,
            )

            Text(
                text = "Feels like -2°",
                color = contentColor.value.color("contentColor"),
                fontSize = 18.sp
            )
        }


        Text(
            text = "January 18, 16:24",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.layoutId("txtDate")
        )

        Text(
            text = "Day 3°\nNight -1°",
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier.layoutId("txtDayNightTemp")
        )


        Image(
            painter = painterResource(id = R.drawable.cloud_and_sun),
            contentDescription = null,
            modifier = Modifier.layoutId("imgCurrentWeather")
        )

        Text(
            text = "Cloudy",
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.W300,
            modifier = Modifier.layoutId("txtCurrentTempTitle")
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .layoutId("days_selection")
        ) {

            val daysOptionsList = listOf("Today", "Tomorrow", "10 Days")

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                daysOptionsList.forEachIndexed { index, title ->

                    val bgColor = if (index == selectedIndex) {
                        Color(0xFFE0B6FF)
                    } else Color.White
                    val shape = RoundedCornerShape(30)
                    Button(
                        onClick = { selectedIndex = index },
                        modifier = Modifier
                            .weight(1f)
                            .height(42.dp),
                        shape = shape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = bgColor,
                            contentColor = TextColor
                        )
                    ) {
                        Text(
                            text = title,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
        LazyColumn(
            modifier = Modifier
                .layoutId("box")
                .fillMaxWidth()
                .nestedScroll(nestedScrollConnection)
        ) {
            item {
                if (selectedIndex == 0 || selectedIndex == 1)
                    DailyWeatherUI()
                else TenDaysWeatherUI()
            }
        }

    }
}

