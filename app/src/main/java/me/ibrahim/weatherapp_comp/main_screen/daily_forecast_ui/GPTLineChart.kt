package me.ibrahim.weatherapp_comp.main_screen.daily_forecast_ui

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.abs

data class Point(val x: Float, val y: Float)

@Composable
fun GPTLineChart(
    points: List<Point>,
    modifier: Modifier = Modifier,
    lineColor: Color = Color.Blue,
    gradientColor: Color = Color.Cyan,
    pointColor: Color = Color.Red
) {
    val xLabels = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    val maxTemp = (points.maxOfOrNull { it.y } ?: 0f) * 1.1f  // 10% buffer

    // Generate y-axis labels from 0 to maxTemp in increments based on chart height
    val yStep = maxTemp / 5  // 5 divisions on y-axis for better readability
    val yLabels = (0..5).map { (it * yStep).toInt().toString() + "°C" }

    Canvas(
        modifier = modifier
            .fillMaxWidth()
    ) {
        if (points.isNotEmpty()) {
            // Define spacing and size constraints
            val maxX = size.width
            val maxY = size.height
            val padding = 100f


            // Map points to canvas coordinates
            val mappedPoints = points.map {
                Offset(
                    x = padding + it.x / 6 * (maxX - padding * 2) + 8.dp.toPx(), // Scale x
                    y = maxY - padding - (it.y / maxTemp * (maxY - padding * 2)) // Scale y
                )
            }


            // Draw the x-axis labels (days of the week)
            xLabels.forEachIndexed { index, label ->
                val x = padding + (index / 6f) * (maxX - padding * 2) + 8.dp.toPx()
                drawContext.canvas.nativeCanvas.drawText(
                    label,
                    x,
                    maxY - 30f, // Positioned slightly above the bottom edge
                    Paint().apply {
                        color = android.graphics.Color.BLACK
                        textSize = 15.sp.toPx()
                        textAlign = Paint.Align.CENTER
                    }
                )
            }


            // Draw the y-axis labels (temperature scales)
            yLabels.forEachIndexed { index, label ->
                val y = maxY - padding - (index / 5f) * (maxY - padding * 2) // Divides y-axis evenly
                drawContext.canvas.nativeCanvas.drawText(
                    label,
                    padding - 5.dp.toPx(),  // Positioned on the left
                    y,
                    Paint().apply {
                        color = android.graphics.Color.BLACK
                        textSize = 15.sp.toPx()
                        textAlign = Paint.Align.RIGHT
                    }
                )
            }

            // Draw the gradient under the curve
            val gradientPath = Path().apply {
                moveTo(mappedPoints.first().x, maxY - padding) // Start at bottom left
                lineTo(mappedPoints.first().x, mappedPoints.first().y)
                for (i in 1 until mappedPoints.size) {
                    val prev = mappedPoints[i - 1]
                    val current = mappedPoints[i]
                    val diff = abs(current.x - prev.x) * 0.55f
                    val controlPointX1 = prev.x + diff
                    val controlPointX2 = current.x - diff
                    val controlPointY1 = prev.y
                    val controlPointY2 = current.y
                    cubicTo(controlPointX1, controlPointY1, controlPointX2, controlPointY2, current.x, current.y)
                }
                lineTo(mappedPoints.last().x, maxY - padding) // Extend to bottom right
                close() // Close the path to create a fillable area
            }

            drawPath(
                path = gradientPath,
                brush = Brush.verticalGradient(
                    colors = listOf(gradientColor, Color.Transparent),
                    startY = maxY - padding * 20,
                    endY = maxY - padding
                )
            )

            // Draw the line path with quadratic curves
            val path = Path().apply {
                moveTo(mappedPoints.first().x, mappedPoints.first().y)

                for (i in 1 until mappedPoints.size) {
                    val prev = mappedPoints[i - 1]
                    val current = mappedPoints[i]
                    val diff = abs(current.x - prev.x) * 0.5f

                    val controlPointX1 = prev.x + diff
                    val controlPointX2 = current.x - diff
                    val controlPointY1 = prev.y
                    val controlPointY2 = current.y

                    cubicTo(controlPointX1, controlPointY1, controlPointX2, controlPointY2, current.x, current.y)
                }
            }

            drawPath(
                path = path,
                color = lineColor,
                style = Stroke(width = 3.dp.toPx())
            )

            // Draw data points
            mappedPoints.forEach { point ->
                drawCircle(
                    color = pointColor,
                    radius = 4.dp.toPx(),
                    center = point
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GPTLineChartPreview() {
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
            .height(300.dp),
        lineColor = Color.Black,
        gradientColor = Color.Gray,
        pointColor = Color.Black
    )
}
