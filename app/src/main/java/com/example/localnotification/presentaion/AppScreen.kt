package com.example.localnotification.presentaion

sealed class AppScreen(val route: String) {
    object Splash : AppScreen(route = "splash")
    object Menu : AppScreen(route = "menu")
}
