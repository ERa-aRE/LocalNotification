package com.example.localnotification.presentaion.screens.matrimony

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.localnotification.presentaion.navigation.AppScreen

@Composable
fun MatrimonyScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Matrimony", fontSize = 50.sp,
            modifier = Modifier.clickable { navController.navigate(route = AppScreen.SpecialEvents.route) })

    }

}