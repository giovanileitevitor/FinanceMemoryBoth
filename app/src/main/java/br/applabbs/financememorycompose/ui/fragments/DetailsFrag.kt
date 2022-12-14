package br.applabbs.financememorycompose.ui.fragments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun DetailsFragPreview(){
    DetailsFrag()
}

@Composable
fun DetailsFrag(modifier: Modifier = Modifier){
    WaterCounter()
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        //opt 1
        val count1 : MutableState<Int> = remember{ mutableStateOf(0) }

        //opt 2
        var count2 by rememberSaveable { mutableStateOf(0) }

        if(count2 > 0 ){
            var showTask by rememberSaveable { mutableStateOf(true)}
            if(showTask){
                WellnessTaskItem(
                    onClose = { showTask = false },
                    taskName = "Have you taken 15 minutes walk today?"
                )
            }
            Text("You`ve had $count2 glasses.")
        }

        Row(Modifier.padding(top = 8.dp)) {
            Button(onClick = { count2++ }, enabled = count2 < 10) {
                Text("Add one")
            }
            Button(onClick = { count2 = 0 }, modifier = Modifier.padding(start = 8.dp)) {
                Text("Clear water count")
            }
        }
    }
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = taskName
        )
        IconButton(
            onClick = onClose
        ) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}