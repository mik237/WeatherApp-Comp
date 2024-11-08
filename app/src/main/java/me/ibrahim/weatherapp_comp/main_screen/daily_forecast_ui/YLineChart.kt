package me.ibrahim.weatherapp_comp.main_screen.daily_forecast_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine

@Composable
fun YLineChart(pointsData: List<Point>) {


    val steps = pointsData.size - 1
    val yLabels = pointsData.sortedBy { it.y }

    val xAxisData = AxisData.Builder()
        .startPadding(20.dp)
        .axisLabelColor(Color.Red)
        .axisLabelFontSize(16.sp)
        .axisOffset(10.dp)
        .axisStepSize(60.dp)
        .backgroundColor(Color.Transparent)
        .labelAndAxisLinePadding(10.dp)
        .steps(steps + 1)
        .labelData { i ->
            if (i in 0..steps) {
                val x = pointsData[i].x
                when (x) {
                    0f -> "Mon"
                    1f -> "Tue"
                    2f -> "Wed"
                    3f -> "Thu"
                    4f -> "Fri"
                    5f -> "Sat"
                    6f -> "Sun"
                    else -> "Mon"
                }
            } else ""
        }
        .labelAndAxisLinePadding(15.dp)
        .build()

    val yAxisData = AxisData.Builder()
        .steps(steps)
        .backgroundColor(Color.Transparent)
        .labelAndAxisLinePadding(10.dp)
        .labelData { i ->
            if (i in 0..steps) {
                val y = yLabels[i].y
                y.toString()
            } else "0"
        }.build()


    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(),
                    IntersectionPoint(color = Color.Blue, radius = 5.dp),
                    SelectionHighlightPoint(),
                    ShadowUnderLine(brush = Brush.verticalGradient(listOf(Color.Blue, Color.LightGray))),
                    SelectionHighlightPopUp()
                )
            ),
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(enableVerticalLines = false),
        backgroundColor = Color.Transparent,
        paddingRight = 0.dp,
        containerPaddingEnd = 10.dp
    )

    LineChart(
        modifier = Modifier
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(250.dp),
        lineChartData = lineChartData
    )
}

@Preview(showBackground = true)
@Composable
private fun YLineChartPreview() {
    val pointsData: List<Point> =
        listOf(
            Point(0f, 20f),
            Point(1f, 25f),
            Point(2f, 30f),
            Point(3f, 22f),
            Point(4f, 27f),
            Point(5f, 18f),
            Point(6f, 24f)
        )
    YLineChart(pointsData)
}