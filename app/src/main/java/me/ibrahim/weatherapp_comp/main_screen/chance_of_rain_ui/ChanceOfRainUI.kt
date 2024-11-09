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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.ibrahim.weatherapp_comp.R
import me.ibrahim.weatherapp_comp.ui.theme.Purple80


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

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
            ) {
                items(rainChances, key = { it.time }) {
                    RainChanceAtTime(time = it.time, chance = it.chance)
                }
            }
        }
    }
}

val rainChances = listOf(
    /*RainChance("12 AM", 50),
    RainChance("1 AM", 60),
    RainChance("2 AM", 70),
    RainChance("3 AM", 50),
    RainChance("4 AM", 40),
    RainChance("5 AM", 60),
    RainChance("6 AM", 30),
    RainChance("7 AM", 20),
    RainChance("8 AM", 10),*/
    RainChance("9 AM", 30),
    RainChance("10 AM", 60),
    RainChance("11 AM", 90),
    RainChance("12 PM", 40),
/*    RainChance("1 PM", 55),
    RainChance("2 PM", 43),
    RainChance("3 PM", 23),
    RainChance("4 PM", 67),
    RainChance("5 PM", 56),
    RainChance("7 PM", 51),
    RainChance("8 PM", 34),
    RainChance("9 PM", 39),
    RainChance("10 PM", 46),
    RainChance("11 PM", 60),*/
)

data class RainChance(val time: String, val chance: Int)