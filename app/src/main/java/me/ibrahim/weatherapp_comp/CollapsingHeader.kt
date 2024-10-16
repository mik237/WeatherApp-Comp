package me.ibrahim.weatherapp_comp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene

@OptIn(ExperimentalMotionApi::class)
@Composable
fun CollapsingHeader(progress: Float) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }



    MotionLayout(
        motionScene = MotionScene(content = motionScene), progress = progress,
        modifier = Modifier.fillMaxWidth(),
        /*debug = EnumSet.of(MotionLayoutDebugFlags.SHOW_ALL)*/
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .layoutId("box")
        )

        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .border(2.dp, color = Color.Green, shape = CircleShape)
                .layoutId("profile_pic")
        )

        Text(
            text = "Muhammad Ibrahim",
            fontSize = 24.sp,
            modifier = Modifier.layoutId("username")
        )
    }
}