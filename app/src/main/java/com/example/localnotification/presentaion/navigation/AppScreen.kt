package com.example.localnotification.presentaion.navigation

sealed class AppScreen(val route: String) {
    object Splash : AppScreen(route = "splash")
    object AboutUs: AppScreen(route = "aboutus")
    object BirthDays: AppScreen(route = "birthdays")
    object Matrimony: AppScreen(route = "matrimony")
    object SpecialEvents: AppScreen(route = "specialevents")
    object WorkEvents: AppScreen(route = "workevents")
    object HomeScreen: AppScreen(route = "Home")
}
