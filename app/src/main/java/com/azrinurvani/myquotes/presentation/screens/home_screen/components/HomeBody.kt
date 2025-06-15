package com.azrinurvani.myquotes.presentation.screens.home_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeBody(
    onClick : () -> Unit = {}
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        item {
            HeadingTitle(
                title = "Random Quote",
                textColor = if (isSystemInDarkTheme()) Color.Black else Color.White
            )
            RandomQuotesItem()

        }
        item {
            HeadingTitle(
                title = "Quotes",
                textColor = if (isSystemInDarkTheme()) Color.Black else Color.White
            )
        }
        items(count = 10){
            QuotesItem(modifier = Modifier.clickable {
                onClick()
            })
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeBodyPreview(){
    HomeBody()
}