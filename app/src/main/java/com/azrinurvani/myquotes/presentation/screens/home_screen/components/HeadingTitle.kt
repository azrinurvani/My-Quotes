package com.azrinurvani.myquotes.presentation.screens.home_screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeadingTitle(
    title : String,
    textColor : Color = Color.Black
){
    Text(
        text = title,
        color = textColor,
        fontSize = 16.sp,
        fontWeight = FontWeight.W800,
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    )
}

@Preview
@Composable
private fun HeadingTitlePreview(){
    HeadingTitle(title = "Random Quote")
}