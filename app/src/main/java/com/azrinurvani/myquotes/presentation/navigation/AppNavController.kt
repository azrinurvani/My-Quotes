package com.azrinurvani.myquotes.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.azrinurvani.myquotes.presentation.screens.detail_screen.DetailScreen
import com.azrinurvani.myquotes.presentation.screens.home_screen.HomeScreen

@Composable
fun AppNavController(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenName.HOME_SCREEN){
        composable(route = ScreenName.HOME_SCREEN){
            HomeScreen(onClick = { id ->
                navController.navigate(ScreenName.DETAIL_SCREEN + "/$id")
            })
        }
        composable(route = ScreenName.DETAIL_SCREEN + "/{id}", arguments = listOf(
            navArgument(name = "id"){
                type = NavType.StringType
            }
        )){
            Log.d("AppNavController", "Detail Screen Args : ${it.arguments?.getString("id")}")
            DetailScreen(
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}