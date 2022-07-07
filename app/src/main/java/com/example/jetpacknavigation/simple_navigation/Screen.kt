package com.example.jetpacknavigation.simple_navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Screen1(
    navController: NavController
) {
    var text by remember{
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = text, onValueChange = {
            text = it
        })

        Button(onClick = {
            navController.navigate(NavigationRoutes.Screen2.setArg(msg = text))
        }) {
            Text(text = "Go to Screen 2 with require arg")
        }

        Button(onClick = {
            if (text.isEmpty()){
                navController.navigate(NavigationRoutes.Screen3.routes)
            }else{
                navController.navigate(NavigationRoutes.Screen3.setArg(sender = text))
            }
        }) {
            Text(text = "Go to Screen 3 with optional arg")
        }

        Button(onClick = {
            navController.navigate(NavigationRoutes.Screen4.routes)
        }) {
            Text(text = "Go to Screen 4")
        }

        Button(onClick = {
            navController.navigate(NavigationRoutes.Screen5.routes)
        }) {
            Text(text = "Go to Screen 5")
        }


    }
}


//require args
@Composable
fun Screen2(
    navController: NavController,
    msg : String  = ""
){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "hello $msg")
    }
}

@Composable
fun Screen3(
    navController: NavController,
    sender : String
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "hello sender $sender")
    }
}

@Composable
fun Screen4(
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Screen 4")
    }
}

@Composable
fun Screen5(
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Screen 5")
    }
}