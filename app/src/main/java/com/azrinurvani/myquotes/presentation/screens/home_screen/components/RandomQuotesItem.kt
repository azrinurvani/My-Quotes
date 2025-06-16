package com.azrinurvani.myquotes.presentation.screens.home_screen.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.azrinurvani.myquotes.domain.models.QuotesDto


@Composable
fun RandomQuotesItem(
    quote : QuotesDto?
){
    QuotesItem(
        quote = quote,
        color = Color.Red,
        textColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
    )
}

@Preview(showBackground = true)
@Composable
private fun RandomQuoteItemPreview(){
    RandomQuotesItem(QuotesDto())
}