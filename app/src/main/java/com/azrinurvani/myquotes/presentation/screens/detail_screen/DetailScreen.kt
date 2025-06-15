package com.azrinurvani.myquotes.presentation.screens.detail_screen

import androidx.compose.foundation.background
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
import com.azrinurvani.myquotes.presentation.screens.detail_screen.components.DetailQuote

@Composable
fun DetailScreen(
    onBackPressed : () -> Unit = {}
){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            ToolbarComponent(
                title = "Detail",
                showBackButton = true,
                onBackPressed = onBackPressed
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ){
            DetailQuote()
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DetailScreenPreview(){
    DetailScreen()
}