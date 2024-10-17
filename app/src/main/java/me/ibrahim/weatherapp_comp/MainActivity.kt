package me.ibrahim.weatherapp_comp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
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
        modifier = Modifier.fillMaxSize(),
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




