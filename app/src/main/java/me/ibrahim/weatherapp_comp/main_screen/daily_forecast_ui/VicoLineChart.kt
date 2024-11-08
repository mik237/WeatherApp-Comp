package me.ibrahim.weatherapp_comp.main_screen.daily_forecast_ui

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.asAndroidPath
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun VicoLineChart() {

    val spacing = 3.0f
    val points = listOf(0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f)
    Canvas(modifier = Modifier) {
        val spacePerHour = (size.width - spacing) / points.size
        var lastX = 0f
        val normX = mutableListOf<Float>()
        val normY = mutableListOf<Float>()

        val strokePath = Path().apply {
            val height = size.height
            for (i in points.indices) {
                val point = points[i]
                val nextInfo = points.getOrNull(i + 1) ?: points.last()
                val leftRatio = (height / 100) * point
                val rightRatio = (height / 100) * nextInfo

                val x1 = spacing + i * spacePerHour
                val y1 = height - spacing - leftRatio.toFloat()
                val x2 = spacing + (i + 1) * spacePerHour
                val y2 = height - spacing - rightRatio.toFloat()

                // Circle dot points
                normX.add(x1)
                normY.add(y1)

                if (i == 0) {
                    moveTo(x1, y1)
                }

                lastX = (x1 + x2) / 2f

                quadraticTo(
                    x1, y1, lastX, (y1 + y2) / 2f
                )
            }
        }
        val fillPath = android.graphics.Path(strokePath.asAndroidPath())
            .asComposePath()
            .apply {
                lineTo(lastX, size.height - spacing)
                lineTo(spacing, size.height - spacing)
                close()
            }
        drawPath(
            path = fillPath,
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color.LightGray.copy(alpha = 0.5f),
                    Color.Transparent
                ),
                endY = size.height - spacing
            )
        )

        drawPath(
            path = strokePath,
            color = Color.Red,
            style = Stroke(
                width = 3.dp.toPx(),
                cap = StrokeCap.Round
            )
        )

        (normX.indices).forEach {
            drawCircle(
                Color.White,
                radius = 3.dp.toPx(),
                center = Offset(normX[it], normY[it])
            )
        }
    }
}