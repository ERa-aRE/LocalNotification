package com.example.localnotification.presentaion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.localnotification.presentaion.SplashScreen
import com.example.localnotification.presentaion.datePicker
import com.example.localnotification.presentaion.screens.about.AboutScreen
import com.example.localnotification.presentaion.screens.birthday.BirthDayScreen
import com.example.localnotification.presentaion.screens.home.HomeScreen
import com.example.localnotification.presentaion.screens.matrimony.MatrimonyScreen
import com.example.localnotification.presentaion.screens.specialevents.SpecialEventsScreen
import com.example.localnotification.presentaion.screens.workEvent.WorkEventsScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController,
            startDestination = AppScreen.Splash.route){
        composable(
            route = AppScreen.Splash.route
        ){
            SplashScreen(navController = navController)
        }
        composable(
            route = AppScreen.AboutUs.route
        ){
            AboutScreen(navController = navController)
        }
        composable(
            route = AppScreen.BirthDays.route
        ){
            BirthDayScreen(navController = navController)
        }
        composable(
            route = AppScreen.Matrimony.route
        ){
            MatrimonyScreen(navController = navController)
        }
        composable(
            route = AppScreen.SpecialEvents.route
        ){
            SpecialEventsScreen(navController = navController)
        }
        composable(
            route = AppScreen.WorkEvents.route
        ){
            WorkEventsScreen(navController = navController)
        }
        composable(
            route = AppScreen.HomeScreen.route
        ){
            HomeScreen(navController = navController)
        }
    }
}