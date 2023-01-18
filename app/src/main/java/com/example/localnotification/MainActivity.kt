package com.example.localnotification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.work.*
import com.example.localnotification.domain.ArbitraryInfo
import com.example.localnotification.presentaion.CurvedScrollView
import com.example.localnotification.ui.theme.LocalNotificationTheme
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        dateCheckerFunction()
        super.onCreate(savedInstanceState)
        val service = NotificationService(applicationContext)
        val menuList =
            listOf(
                "Birthdays",
                "Marriage",
                "Special events",
                "Work events",
                "setting",
                "about us",
                "contact us",
                ""
            )
        setContent {
            LocalNotificationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting(service)
                    CurvedScrollView(menuList) { eachRoute ->
                        cardView(text = eachRoute)

                    }
                }
            }
        }
    }

    @Composable
    private fun cardView(text: String) {
        Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.Center) {
            Text(text = text)
        }
    }


    fun dateCheckerFunction() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .build()
        val workRequest = PeriodicWorkRequest.Builder(
            Worker::class.java,
            1,
            TimeUnit.DAYS
        ).setConstraints(constraints)
            .addTag("first worker")
            .build()
        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork("first worker", ExistingPeriodicWorkPolicy.KEEP, workRequest)

    }
}

@Composable
fun Greeting(service: NotificationService) {
    var name by remember {
        mutableStateOf("")
    }
    var age by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = name,
            onValueChange = {
                name = it

            },
            placeholder = { Text("name") })
        TextField(
            value = age,
            onValueChange = {
                age = it

            },
            label = { Text("age") })


        Button(
            onClick = {
                service.showNotification(ArbitraryInfo(name, age))
            })
        {
            Text("Click here for a notification")
        }

    }
}

