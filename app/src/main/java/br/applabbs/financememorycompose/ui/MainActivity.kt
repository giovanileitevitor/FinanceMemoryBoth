package br.applabbs.financememorycompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.applabbs.financememorycompose.R
import br.applabbs.financememorycompose.ui.fragments.ConfigFrag
import br.applabbs.financememorycompose.ui.fragments.DetailsFrag
import br.applabbs.financememorycompose.ui.fragments.HomeFrag
import br.applabbs.financememorycompose.ui.fragments.Message
import br.applabbs.financememorycompose.ui.main.BottomBar
import br.applabbs.financememorycompose.ui.main.NavigationItem
import br.applabbs.financememorycompose.ui.main.TopBar
import br.applabbs.financememorycompose.ui.viewmodels.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(viewModel = viewModel)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}

@Composable
fun MainScreen(viewModel: MainViewModel = MainViewModel()) {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar(navController = navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)){
                Navigation(navController = navController)
            }
        },
        backgroundColor = colorResource(id = R.color.gray)
    )
}

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController =  navController, startDestination = NavigationItem.Home.route){
        composable(route = NavigationItem.Home.route){
            HomeFrag()
        }
        composable(route = NavigationItem.Details.route){
            DetailsFrag()
        }
        composable(route = NavigationItem.Config.route){
            ConfigFrag(msg = Message("Android", "All Books"))
        }
    }
}

