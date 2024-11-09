package me.ibrahim.weatherapp_comp.main_screen.chance_of_rain_ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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