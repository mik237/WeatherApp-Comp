package me.ibrahim.weatherapp_comp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import me.ibrahim.weatherapp_comp.ui.theme.TextColor
import me.ibrahim.weatherapp_comp.ui.theme.WeatherAppCompTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppCompTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    val scrollState = rememberScrollState()

                    val progress by remember {
                        derivedStateOf {
                            val currentScroll = scrollState.value
                            val maxScroll = scrollState.maxValue
                            val headerHeight = 400

                            val progress = if (currentScroll > headerHeight) {
                                1f
                            } else if (currentScroll in 1..headerHeight) {
                                currentScroll.toFloat() / headerHeight
                            } else 0f

                            Log.d(
                                "derivedStateOf",
                                "currentScroll: $currentScroll, maxScroll:$maxScroll, headerHeight:$headerHeight, progress:$progress"
                            )
                            progress
                        }
                    }
                    WeatherHeader(progress = progress, scrollState)
                }
            }
        }
    }
}


@OptIn(ExperimentalMotionApi::class)
@Composable
fun WeatherHeader(progress: Float, scrollState: ScrollState) {

    val context = LocalContext.current
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.weather_header_motion_scene)
            .readBytes()
            .decodeToString()
    }

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF6EDFF)),
        /*debug = EnumSet.of(MotionLayoutDebugFlags.SHOW_ALL)*/
    ) {
        val boxProperties = motionProperties(id = "box")
        val imgProperties = motionProperties(id = "bg_image")

        Image(
            painter = painterResource(id = R.drawable.bg_header_img),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
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
                .fillMaxWidth()
                .layoutId("days_selection")
        ) {

            val daysOptionsList = listOf("Today", "Tomorrow", "10 Days")
            var selectedIndex by remember { mutableIntStateOf(0) }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                daysOptionsList.forEachIndexed { index, title ->

                    val bgColor = if (index == selectedIndex) {
                        Color(0xFFE0B6FF)
                    } else Color.White
                    val shape = RoundedCornerShape(30)
                    Button(
                        onClick = { selectedIndex = index },
                        modifier = Modifier
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

        Column(
            modifier = Modifier
                .layoutId("box")
                .verticalScroll(scrollState)
                .background(color = boxProperties.value.color("background"))
        ) {

            repeat(20) {
                val bgColor = if (it == 0) Color.Red else Color.Green
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(10.dp)
                        .background(color = bgColor)
                )
            }

        }
    }
}




