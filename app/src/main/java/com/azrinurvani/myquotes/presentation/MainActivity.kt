package com.azrinurvani.myquotes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.azrinurvani.myquotes.presentation.navigation.AppNavController
import com.azrinurvani.myquotes.presentation.screens.home_screen.HomeScreen
import com.azrinurvani.myquotes.presentation.ui.theme.MyQuotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyQuotesTheme {
                AppNavController()
            }
        }
    }
}