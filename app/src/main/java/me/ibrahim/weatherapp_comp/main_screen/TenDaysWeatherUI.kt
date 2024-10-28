package me.ibrahim.weatherapp_comp.main_screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import me.ibrahim.weatherapp_comp.ui.theme.Purple80

@Composable
fun TenDaysWeatherUI(scrollState: ScrollState) {
    Column(
        modifier = Modifier
            .layoutId("box")
            .verticalScroll(scrollState)
    ) {
        repeat(20) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(vertical = 5.dp)
                    .background(Purple80, shape = RoundedCornerShape(16.dp))
            )
        }
    }
}