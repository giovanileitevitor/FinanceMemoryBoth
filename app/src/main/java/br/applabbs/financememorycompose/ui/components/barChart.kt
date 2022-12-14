package br.applabbs.financememorycompose.ui.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.applabbs.financememorycompose.ui.theme.Purple500

@Composable
fun BarChart(
    data: Map<Float, String>,
    max_value: Int
) {

    val context = LocalContext.current

    // BarGraph Dimensions
    val barGraphHeight by remember { mutableStateOf(200.dp) }
    val barGraphWidth by remember { mutableStateOf(14.dp) }

    // Scale Dimensions
    val scaleYAxisWidth by remember { mutableStateOf(20.dp) }
    val scaleLineWidth by remember { mutableStateOf(1.dp) }

    Column(
        modifier = Modifier.padding(2.dp).fillMaxWidth().fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(barGraphHeight),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
//            // scale Y-Axis
//            Box(
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(scaleYAxisWidth),
//                contentAlignment = Alignment.BottomCenter
//            ) {
//                Column(
//                    modifier = Modifier.fillMaxHeight(),
//                    verticalArrangement = Arrangement.Bottom
//                ) {
//                    Text(text = max_value.toString())
//                    Spacer(modifier = Modifier.fillMaxHeight())
//                }
//
//                Column(
//                    modifier = Modifier.fillMaxHeight(),
//                    verticalArrangement = Arrangement.Bottom
//                ) {
//                    Text(text = (max_value / 2).toString())
//                    Spacer(modifier = Modifier.fillMaxHeight(0.5f))
//                }
//
//            }

            // Y-Axis Line
//            Box(
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .width(scaleLineWidth)
//                    .background(Color.Black)
//            )

            // graph
            data.forEach {
                Box(
                    modifier = Modifier
                        .padding(start = barGraphWidth, bottom = 0.dp)
                        //.clip(CircleShape)
                        .width(width = barGraphWidth)
                        .fillMaxHeight(it.key)
                        .background(Color.Black)
                        .clickable(
                            role = Role.Button,
                            onClickLabel = "Item Gráfico"
                        ) {
                            Toast
                                .makeText(context, it.key.toString() + "=" + it.value.toString(), Toast.LENGTH_SHORT)
                                .show()
                        }
                )
            }

        }

        // X-Axis Line
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(scaleLineWidth)
                .background(Color.Black)
        )

        // Scale X-Axis
        Row(
            modifier = Modifier
                .padding(start = barGraphWidth)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(barGraphWidth)
        ) {

            data.values.forEach {
                Text(
                    modifier = Modifier.width(barGraphWidth),
                    text = it,
                    textAlign = TextAlign.Center,
                    fontSize = 8.sp
                )
            }

        }

    }

}

@Preview(showBackground = true, name = "grafico")
@Composable
fun BarChartPreview(){
    BarChart(data = mapOf(
        Pair(0.1f, "Jan"),
        Pair(0.2f, "Fev"),
        Pair(0.3f, "Mar"),
        Pair(0.4f, "Abr"),
        Pair(0.5f, "Mai"),
        Pair(0.6f, "Jun"),
        Pair(0.7f, "Jul"),
        Pair(0.8f, "Ago"),
        Pair(0.9f, "Set"),
        Pair(0.91f, "Out"),
        Pair(0.92f, "Nov"),
        Pair(0.93f, "Dez")
    ) ,
        max_value = 1000)
}

