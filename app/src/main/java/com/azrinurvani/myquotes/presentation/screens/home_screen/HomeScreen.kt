

package com.azrinurvani.myquotes.presentation.screens.home_screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.azrinurvani.myquotes.domain.models.HomeQuotes
import com.azrinurvani.myquotes.network.NetworkUIState
import com.azrinurvani.myquotes.presentation.components.AppProgressBar
import com.azrinurvani.myquotes.presentation.components.ToolbarComponent
import com.azrinurvani.myquotes.presentation.screens.home_screen.components.HomeBody

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    onClick : (id : String) -> Unit = {}
){
    val context : Context = LocalContext.current
    val state = homeViewModel.quotesData.collectAsStateWithLifecycle().value

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
            when (state) {
                is NetworkUIState.Error -> {
                    Log.e("HomeScreen", "error : ${state.message}", )
                    Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
                }
                is NetworkUIState.Loading -> {
                    AppProgressBar()
                }
                is NetworkUIState.Success<HomeQuotes> -> {
                    HomeBody(homeQuotes = state.data,onClick = onClick)
                }
            }

        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun HomeScreenPreview(){
    HomeScreen()
}