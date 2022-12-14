package br.applabbs.financememorycompose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun barStatusPreview(){
    BarStatus(
        valorMes = "R$450,00",
        valorAno = "R$1500,00"
    )
}

@Composable
fun BarStatus(
    valorMes : String,
    valorAno: String,
    modifier: Modifier = Modifier
){
    Card(
        border = BorderStroke(1.dp, Color.Black),
        backgroundColor = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(20))
            .padding(4.dp)

    ){

    }
}