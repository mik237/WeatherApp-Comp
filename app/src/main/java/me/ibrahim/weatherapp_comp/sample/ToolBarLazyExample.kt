package me.ibrahim.weatherapp_comp.sample


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import me.ibrahim.weatherapp_comp.R

/**
 * A demo of using MotionLayout as a collapsing Toolbar using JSON to define the MotionScene
 */
@OptIn(ExperimentalMotionApi::class)
@Preview(group = "scroll", device = "spec:shape=Normal,width=480,height=800,unit=dp,dpi=440")
@Composable
fun ToolBarLazyExample() {
    val scroll = rememberScrollState(0)

    val scene = """
      {
        ConstraintSets: {
          start: {
            title: {
              bottom: ['image', 'bottom', 16],                
              start: [ 'image','start', 16],
              },
            image: {
            width: 'spread',
              height: 250,
              top: ['parent', 'top', 0],
              start: ['parent', 'start', 0],
              end: ['parent', 'end', 0],
              custom: {
                cover: '#000000FF'
              }
            },
            box: {
            width: 'spread',
            height: 'spread',
            top: ['image', 'bottom', 0],
            start: ['parent', 'start', 0],
            end: ['parent', 'end', 0],
            bottom: ['parent', 'bottom', 0],
            }
          },
          end: {
            title: {
              centerVertically: 'image',
              start: ['icon', 'end', 0],
              scaleX: 0.7,
              scaleY: 0.7,
            },
            image: {
              width: 'spread',
              height: 50,
              top: ['parent', 'top', 0],
              start: ['parent', 'start', 0],
              end: ['parent', 'end', 0],
              custom: {
                cover: '#FF0000FF'
              }
            },
            box: {
            width: 'spread',
            height: 'spread',
            top: ['image', 'bottom', 0],
            start: ['parent', 'start', 0],
            end: ['parent', 'end', 0],
            bottom: ['parent', 'bottom', 0],
            }
          },
        },
        Transitions: {
          default: {
            from: 'start',
            to: 'end',
            pathMotionArc: 'startHorizontal',
          },
        },
      }
      """

    val maxPx = with(LocalDensity.current) { 250.dp.toPx() }
    val minPx = with(LocalDensity.current) { 50.dp.toPx() }
    val toolbarHeight = remember { mutableFloatStateOf(maxPx) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val height = toolbarHeight.floatValue;

                if (height + available.y > maxPx) {
                    toolbarHeight.floatValue = maxPx
                    return Offset(0f, maxPx - height)
                }

                if (height + available.y < minPx) {
                    toolbarHeight.floatValue = minPx
                    return Offset(0f, minPx - height)
                }

                toolbarHeight.floatValue += available.y
                return Offset(0f, available.y)
            }

        }
    }

    val progress = 1 - (toolbarHeight.floatValue - minPx) / (maxPx - minPx)

    Column {
        MotionLayout(
            modifier = Modifier.background(Color.Green).fillMaxSize(),
            motionScene = MotionScene(content = scene),
            progress = progress
        ) {
            Image(
                modifier = Modifier.layoutId("image"),
                painter = painterResource(R.drawable.bg_header_img),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )


            Text(
                modifier = Modifier.layoutId("title"),
                text = "San Francisco",
                fontSize = 30.sp,
                color = Color.White
            )

            LazyColumn(
                modifier = Modifier
                    .layoutId("box")
                    .fillMaxWidth()
                    .nestedScroll(nestedScrollConnection)
            ) {
                items(50) {
                    Text(
                        text = "item $it", modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    )
                }
            }
        }

    }
}