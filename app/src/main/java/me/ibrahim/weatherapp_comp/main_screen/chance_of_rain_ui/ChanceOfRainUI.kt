package me.ibrahim.weatherapp_comp.main_screen.chance_of_rain_ui

import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.weatherapp_comp.R
import me.ibrahim.weatherapp_comp.ui.theme.Purple80


@Preview
@Composable
fun ChanceOfRainUI() {
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
                    painter = painterResource(id = R.drawable.icon_rain_chance),
                    contentDescription = null
                )
                Text(
                    text = stringResource(id = R.string.chance_of_rain),
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            RainChanceAtTime("7 PM", 80)
            RainChanceAtTime("9 PM", 0)
        }
    }
}


@Composable
fun RainChanceAtTime(
    time: String, chance: Int,
    progressColor: Color = Color(0xff8A20D5),
    bgColor: Color = Color(0xffFAEDFF)
) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = time, fontSize = 15.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
        CircularProgressIndicator(modifier = Modifier.weight(1f), chance = chance, progressColor, bgColor)
        Text(
            text = "$chance%", fontSize = 15.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun CircularProgressIndicator(modifier: Modifier, chance: Int, progressColor: Color, bgColor: Color) {
    val strokeWidth = 32.dp
    val canvasHeight = strokeWidth + 16.dp

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(canvasHeight)
            .padding(horizontal = 8.dp)
            .graphicsLayer {
                compositingStrategy = CompositingStrategy.Offscreen
            }
    ) {

        val strokeWidthPx = strokeWidth.toPx()
        val halfStrokeWidth = strokeWidthPx / 2f

        val width = size.width
        val yPosition = size.height / 2
        drawLine(
            color = bgColor,
            start = Offset(halfStrokeWidth, yPosition),
            end = Offset(width - halfStrokeWidth, yPosition),
            cap = StrokeCap.Round,
            strokeWidth = strokeWidthPx
        )

        drawLine(
            color = if (chance == 0) bgColor else progressColor,
            start = Offset(0f, yPosition),
            end = Offset(width * (chance / 100f), yPosition),
            strokeWidth = strokeWidthPx,
            blendMode = BlendMode.SrcIn,
            cap = StrokeCap.Round
        )
    }
}