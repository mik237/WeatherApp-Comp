package me.ibrahim.weatherapp_comp.main_screen.daily_forecast_ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random


@Composable
fun CustomLineChart(dataPoints: List<DataPoint>) {

    Canvas(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(250.dp)
    ) {
        val width = size.width
        val height = size.height
        val spacingOf16dpInPx = 16.dp.toPx()
        val verticalAxisLineStartOffset = Offset(spacingOf16dpInPx, spacingOf16dpInPx)
        val verticalAxisLineEndOffset = Offset(spacingOf16dpInPx, height)

        drawLine(
            color = Color.Black,
            start = verticalAxisLineStartOffset,
            end = verticalAxisLineEndOffset,
            strokeWidth = Stroke.DefaultMiter
        )

        val horizontalAxisLineStartOffset = Offset(spacingOf16dpInPx, height)
        val horizontalAxisLineEndOffset = Offset(width - spacingOf16dpInPx, height)

        drawLine(
            color = Color.Black,
            start = horizontalAxisLineStartOffset,
            horizontalAxisLineEndOffset,
            strokeWidth = Stroke.DefaultMiter
        )

        val yMax = dataPoints.yMax()
        val xMax = dataPoints.xMax()
        val gradientPath = Path()
        gradientPath.moveTo(spacingOf16dpInPx, height)

        dataPoints.forEachIndexed { index, dataPoint ->
            var normX = dataPoint.x.toRealX(xMax, width)
            var normY = dataPoint.y.toRealY(yMax, height)

            if (index == 0) normX += spacingOf16dpInPx
            if (index == dataPoints.size - 1) normY -= spacingOf16dpInPx

            if (index < dataPoints.size - 1) {
                val offsetStart = Offset(normX, normY)
                var nextNormXPoint = dataPoints[index + 1].x.toRealX(xMax, width)

                if (index == dataPoints.size - 2)
                    nextNormXPoint = dataPoints[index + 1].x.toRealX(xMax, width) - spacingOf16dpInPx

                val nextNormYPoint = dataPoints[index + 1].y.toRealY(yMax, height)
                val offsetEnd = Offset(nextNormXPoint, nextNormYPoint)

                drawLine(
                    color = Color.Green,
                    start = offsetStart,
                    end = offsetEnd,
                    strokeWidth = Stroke.DefaultMiter
                )
                gradientPath.quadraticTo(
                    x1 = normX, y1 = normY, x2 = nextNormXPoint, y2 = nextNormYPoint
                )
            }

            drawCircle(
                color = Color.Red,
                radius = 3.dp.toPx(),
                center = Offset(normX, normY),
                style = Fill
            )


            with(gradientPath) {
                lineTo(normX, normY)
            }
        }

        with(gradientPath) {
            lineTo(width - spacingOf16dpInPx, height)
            lineTo(0f, height)
            close()
            drawPath(
                this,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Red.copy(alpha = 0.5f),
                        Color.LightGray.copy(alpha = 0.5f)
                    )
                )
            )
        }
    }
}


data class DataPoint(val x: Float, val y: Float)

fun List<DataPoint>.xMax(): Float = maxByOrNull { it.x }?.x ?: 0f
fun List<DataPoint>.yMax(): Float = maxByOrNull { it.y }?.y ?: 0f

fun Float.toRealX(xMax: Float, width: Float) = (this / xMax) * width
fun Float.toRealY(yMax: Float, height: Float) = (this / yMax) * height


@Preview
@Composable
private fun LineChartPreview() {
    val random = Random.Default


    /*val dataPoints = (0..10).map {
        DataPoint(
            it.toFloat(),
            random.nextInt(0,40).toFloat()
        )
    }*/
    val dataPoints = listOf(
        DataPoint(2f, 23f),
        DataPoint(3f, 34f),
        DataPoint(4f, 45f),
        DataPoint(5f, 56f),
        DataPoint(6f, 45f),
        DataPoint(7f, 34f),
        DataPoint(8f, 23f),
        DataPoint(9f, 12f),
    )

    CustomLineChart(dataPoints = dataPoints)
}