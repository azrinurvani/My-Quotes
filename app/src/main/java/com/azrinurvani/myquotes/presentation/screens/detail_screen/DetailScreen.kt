package com.azrinurvani.myquotes.presentation.screens.detail_screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.azrinurvani.myquotes.network.NetworkUIState
import com.azrinurvani.myquotes.presentation.components.AppProgressBar
import com.azrinurvani.myquotes.presentation.components.ToolbarComponent
import com.azrinurvani.myquotes.presentation.screens.detail_screen.components.DetailQuote

@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel = hiltViewModel(),
    onBackPressed : () -> Unit = {}
){
    val context : Context = LocalContext.current
    val state = detailViewModel.singleQuoteData.collectAsStateWithLifecycle().value

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
            when (state){
                is NetworkUIState.Error -> {
                    Log.e("DetailScreen", "error : ${state.message}", )
                    Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
                }
                is NetworkUIState.Loading-> {
                    AppProgressBar()
                }
                is NetworkUIState.Success -> {
                    state.data?.let { DetailQuote(quotes = it) }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun DetailScreenPreview(){
    DetailScreen()
}