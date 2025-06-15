package com.azrinurvani.myquotes.presentation.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarComponent(
    showBackButton : Boolean = false,
    title : String = "",
    onBackPressed : () -> Unit = {}
){
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 18.sp,
                fontWeight = FontWeight.W800,
                textAlign = TextAlign.Center
            )
        },
        colors = TopAppBarColors(
            containerColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
            titleContentColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
            navigationIconContentColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
            actionIconContentColor = if (isSystemInDarkTheme()) Color.Black else Color.White,
            scrolledContainerColor = if (isSystemInDarkTheme()) Color.White else Color.Black
        ),
        navigationIcon = {
            if (showBackButton){
                IconButton(
                    onClick = onBackPressed
                ){
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = if (isSystemInDarkTheme()) Color.Black else Color.White,
                        modifier = Modifier
                            .size(30.dp)
                            .padding(3.dp)
                    )
                }
            }
        },
        actions = {
            if (showBackButton){
                Spacer(modifier = Modifier.size(30.dp))
            }
        }
    )
}

@Preview
@Composable
fun ToolbarComponentPreview(){
    ToolbarComponent(title = "Home", showBackButton = true)
}