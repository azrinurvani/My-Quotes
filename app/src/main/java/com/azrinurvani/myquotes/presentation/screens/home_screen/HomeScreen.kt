

package com.azrinurvani.myquotes.presentation.screens.home_screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.azrinurvani.myquotes.presentation.components.ToolbarComponent
import com.azrinurvani.myquotes.presentation.screens.home_screen.components.HomeBody

@Composable
fun HomeScreen(
    onClick : () -> Unit = {}
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            ToolbarComponent(
                title = "Home"
            )
        },
        containerColor = Color.LightGray
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            HomeBody(onClick = onClick)
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview(){
    HomeScreen()
}