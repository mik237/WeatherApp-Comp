package me.ibrahim.weatherapp_comp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionLayoutDebugFlags
import androidx.constraintlayout.compose.MotionScene
import me.ibrahim.weatherapp_comp.ui.theme.WeatherAppCompTheme
import java.util.EnumSet

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
                    var progress by remember { mutableFloatStateOf(0f) }
                    WeatherHeader(progress = progress)

                    Spacer(modifier = Modifier.height(32.dp))
                    Slider(
                        value = progress, onValueChange = { progress = it },
                        modifier = Modifier.padding(horizontal = 32.dp)
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMotionApi::class)
@Composable
fun WeatherHeader(progress: Float) {
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
        modifier = Modifier.fillMaxWidth(),
        debug = EnumSet.of(MotionLayoutDebugFlags.SHOW_ALL)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_header_img),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Yellow)
                .layoutId("bg_image")
        )
    }
}




