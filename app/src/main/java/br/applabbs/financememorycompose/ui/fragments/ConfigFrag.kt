package br.applabbs.financememorycompose.ui.fragments

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.applabbs.financememorycompose.R

@Preview(showBackground = true)
@Composable
fun ConfigFragPreview(){
    ConfigFrag(msg = Message("Android", "All Books"))
}

@Composable
fun ConfigFrag(msg: Message){

    Row(
        modifier = Modifier.padding(all = 4.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.ion2),
            contentDescription = "img teste",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colors.secondary, CircleShape)

        )

        Column(
            modifier = Modifier.padding(all = 4.dp)
        ) {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant
            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
               shape = MaterialTheme.shapes.medium, elevation = 1.dp
            ){
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }

        }
    }

}

data class Message(val author: String, val body: String)