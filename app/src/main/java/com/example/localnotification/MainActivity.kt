package com.example.localnotification

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.work.*
import com.chargemap.compose.numberpicker.ListItemPicker
import com.chargemap.compose.numberpicker.NumberPicker
import com.example.localnotification.domain.util.ArbitraryInfo
import com.example.localnotification.ui.theme.LocalNotificationTheme
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
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
                    /*CurvedScrollView(menuList) { eachRoute ->
                        cardView(text = eachRoute)

                    }*/
                    NumberAndListCard()
                }
            }
        }
    }

    @Composable
    private fun NumberAndListCard() {
        var day by remember {
            mutableStateOf(0)
        }
        var month by remember {
            mutableStateOf(0)
        }
        var year by remember {
            mutableStateOf(0)
        }
        val persianMonth = listOf(
            "فروردین",
            "اردیبهشت",
            "خرداد",
            "تیر",
            "مرداد",
            "شهریور",
            "مهر",
            "آبان",
            "آذر",
            "دی",
            "بهمن",
            "اسفند"
        )
        var pickerValue by remember { mutableStateOf(15) }
        var pickerValue2 by remember { mutableStateOf(1390) }
        var state by remember { mutableStateOf(persianMonth[0]) }
        Row(modifier= Modifier
            .fillMaxWidth()
            .padding(20.dp)) {


            NumberPicker(
                value = pickerValue,
                range = 1..31,
                onValueChange = {
                    pickerValue = it
                    day =it
                }
            )
            ListItemPicker(
                label = { it },
                value = state,
                onValueChange =
                { state = it
                when(it){
                    "فروردین"-> month=1
                    "اردیبهشت"->month=2
                    "خرداد"->month=3
                    "تیر"->month=4
                    "مرداد"->month=5
                    "شهریور"->month=6
                    "مهر"->month=7
                    "آبان"->month=8
                    "آذر"->month=9
                    "دی"->month=10
                    "بهمن"->month=11
                    "اسفند"->month=12

                }                },
                list = persianMonth
            )
            NumberPicker(
                value = pickerValue2,
                range = 1300..1450,
                onValueChange = {
                    pickerValue2 = it
                    year = it
                }
            )
            Text(text = "year=$year,month=$month,day=$day")

        }

    }

    @Composable
    private fun CardView(text: String) {
        Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.Center) {
            Text(text = text)
        }


    }


    private fun dateCheckerFunction() {
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

