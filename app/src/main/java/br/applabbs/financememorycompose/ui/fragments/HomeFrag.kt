package br.applabbs.financememorycompose.ui.fragments

import android.text.Layout.Alignment
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.applabbs.financememorycompose.R
import br.applabbs.financememorycompose.ui.components.BarChart
import br.applabbs.financememorycompose.ui.components.BarStatus

@Preview(showBackground = true)
@Composable
fun HomeFragPreview(){
    HomeFrag()
}

@Composable
fun HomeFrag(){
    val name = remember { mutableStateOf("")}
    val nameEntered = remember { mutableStateOf(false)}

    Column() {
        BarStatus(
            valorMes = "R$30,00",
            valorAno = "R$450,00"
        )

        BarChart(
            data = mapOf(
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
            ),
            max_value = 100
        )

    }


}


