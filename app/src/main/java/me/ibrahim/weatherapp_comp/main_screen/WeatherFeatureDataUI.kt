package me.ibrahim.weatherapp_comp.main_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import me.ibrahim.weatherapp_comp.ui.theme.Purple80

@Composable
fun WeatherFeatureDataUI(modifier: Modifier = Modifier, icon: Int, title: Int, value: String, rate: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(color = Purple80, shape = RoundedCornerShape(16.dp))
                .padding(12.dp)
        ) {
            val (ic, txtTitle, txtSpeed, txtRate) = createRefs()
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(28.dp)
                    .constrainAs(ic) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
            )

            Text(text = stringResource(id = title),
                fontSize = 14.sp,
                color = Color(0xff1E1B1B),
                modifier = Modifier.constrainAs(txtTitle) {
                    top.linkTo(parent.top)
                    start.linkTo(ic.end, margin = 8.dp)
                    end.linkTo(txtRate.start, 3.dp)
                })

            Text(text = value,
                fontSize = 16.sp,
                color = Color(0xff1E1B1B),
                modifier = Modifier.constrainAs(txtSpeed) {
                    top.linkTo(txtTitle.bottom, margin = 5.dp)
                    start.linkTo(txtTitle.start)
                    bottom.linkTo(parent.bottom)
                })


            Text(text = rate,
                fontSize = 11.sp,
                color = Color(0xff000000),
                modifier = Modifier
                    .constrainAs(txtRate) {
                        end.linkTo(parent.end, 8.dp)
                        bottom.linkTo(parent.bottom)
                    })
        }

    }
}