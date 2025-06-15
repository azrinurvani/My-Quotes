package com.azrinurvani.myquotes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.azrinurvani.myquotes.presentation.screens.detail_screen.DetailScreen
import com.azrinurvani.myquotes.presentation.screens.home_screen.HomeScreen

@Composable
fun AppNavController(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenName.HOME_SCREEN){
        composable(route = ScreenName.HOME_SCREEN){
            HomeScreen(onClick = {
                navController.navigate(ScreenName.DETAIL_SCREEN)
            })
        }
        composable(route = ScreenName.DETAIL_SCREEN){
            DetailScreen(
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}