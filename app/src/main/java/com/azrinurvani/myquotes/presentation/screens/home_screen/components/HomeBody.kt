package com.azrinurvani.myquotes.presentation.screens.home_screen.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.azrinurvani.myquotes.domain.models.HomeQuotes

@Composable
fun HomeBody(
    homeQuotes: HomeQuotes?,
    onClick : (id : String) -> Unit = {}
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
            RandomQuotesItem(
                quote = homeQuotes?.randomQuotes
            )

        }
        item {
            HeadingTitle(
                title = "Quotes",
                textColor = if (isSystemInDarkTheme()) Color.Black else Color.White
            )
        }
        items(items = homeQuotes?.allQuotes ?: emptyList()){
            QuotesItem(
                quote = it,
                modifier = Modifier.clickable {
                onClick(it?.id.toString())
            })
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeBodyPreview(){
    HomeBody(HomeQuotes())
}