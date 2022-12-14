package br.applabbs.financememorycompose.ui.main

import android.widget.Toast
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.applabbs.financememorycompose.R

@Composable
fun TopBar(){

    val context = LocalContext.current

    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name), fontSize = 18.sp)},
        elevation = 4.dp,
        backgroundColor = colorResource(id = R.color.black),
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = {  }) {
                Icon(Icons.Rounded.Menu, "botao voltar")
            }
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Add Registro", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Rounded.Add, "botao adicionar registro")
            }
            IconButton(onClick = {
                Toast.makeText(context, "Share Registro", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Rounded.Share, "botao compartilhar registro")
            }
        }

    )
}

@Preview(showBackground = true, name = "TopBar", showSystemUi = false)
@Composable
fun TopBarPreview(){
    TopBar()
}