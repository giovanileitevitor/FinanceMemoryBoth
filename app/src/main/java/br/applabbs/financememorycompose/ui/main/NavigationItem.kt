package br.applabbs.financememorycompose.ui.main

import br.applabbs.financememorycompose.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {

    object Home: NavigationItem( "home", R.drawable.ic_home, "Home")
    object Details: NavigationItem( "details", R.drawable.ic_details, "Details")
    object Config: NavigationItem( "config", R.drawable.ic_config, "Config")

}