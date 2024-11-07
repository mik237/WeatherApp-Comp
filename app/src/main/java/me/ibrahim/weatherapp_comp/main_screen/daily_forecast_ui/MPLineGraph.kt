package me.ibrahim.weatherapp_comp.main_screen.daily_forecast_ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

@Composable
fun MPLineGraph(
    xData: List<Float>,
    yData: List<Float>,
    dataLabel: String,
    modifier: Modifier = Modifier
) {
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { ctx ->

            val chart = LineChart(ctx) //initialize the chart
            val entries: List<Entry> = xData.zip(yData) { x, y -> Entry(x, y) } //conver x, y data to entries
            val dataSet = LineDataSet(entries, dataLabel) //create a dataset of entries
            chart.data = LineData(dataSet)

            // Enable touch gestures
            chart.setTouchEnabled(true)
            chart.isDragEnabled = true
            chart.isScaleXEnabled = true
            chart.isScaleYEnabled = false
            
            //Refresh & return the chart.
            chart.invalidate()
            chart
        })
}


@Preview
@Composable
fun MPLineGraphPreview(modifier: Modifier = Modifier) {
    val xData = listOf(5.2f, 4.5f, 5.6f)
    val yData = listOf(4f, 8f, 12f)
    val dataLabel = "A"
    MPLineGraph(xData, yData, dataLabel)
}