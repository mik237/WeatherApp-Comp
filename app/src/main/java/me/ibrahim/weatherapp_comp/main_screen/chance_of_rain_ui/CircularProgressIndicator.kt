package me.ibrahim.weatherapp_comp.main_screen.chance_of_rain_ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

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