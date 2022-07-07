package com.example.jetpacknavigation.simple_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation

const val MSG_KEY = "MSG"
const val SENDER_KEY = "SENDER"

@Composable
fun MainNavHost(
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = NavigationRoutes.Screen1.routes,
    ) {
        composable(
            route = NavigationRoutes.Screen1.routes
        ){
            Screen1(navController = navHostController)
        }

        composable(
            route = NavigationRoutes.Screen2.routes,
            arguments = listOf(
                navArgument(MSG_KEY){
                    type = NavType.StringType
                }
            )
        ){
            Screen2(
                navController = navHostController,
                msg = it.arguments?.getString(MSG_KEY).toString()
            )
        }

        composable(
            route = NavigationRoutes.Screen3.routes,
            arguments = listOf(
                navArgument(SENDER_KEY){
                    type = NavType.StringType
                    defaultValue = "User"
                    nullable = true
                }
            )
        ){
            Screen3(navController = navHostController, sender = it.arguments?.getString(SENDER_KEY).toString() )
        }

        ChildNavGraph(
            navController = navHostController
        )
    }

}