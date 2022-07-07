package com.example.jetpacknavigation.simple_navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.ChildNavGraph(
    navController: NavHostController
){
    navigation(
        startDestination = NavigationRoutes.Screen4.routes,
        route = NavigationRoutes.ChildNavGraph.routes
    ){
        composable(
            route = NavigationRoutes.Screen4.routes
        ){
            Screen4(navController = navController)
        }

        composable(
            route = NavigationRoutes.Screen5.routes
        ){
            Screen5(navController = navController)
        }
    }
}