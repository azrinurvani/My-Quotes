package com.azrinurvani.myquotes.presentation.screens.detail_screen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azrinurvani.myquotes.domain.models.QuotesDto
import com.azrinurvani.myquotes.domain.use_cases.GetSingleQuoteUseCase
import com.azrinurvani.myquotes.network.NetworkUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getSingleQuoteUseCase: GetSingleQuoteUseCase
) : ViewModel() {

    var singleQuoteData = MutableStateFlow<NetworkUIState<QuotesDto?>>(NetworkUIState.Loading())
        private set

    init {
        getSingleQuote(savedStateHandle.get<String>("id") ?: "")
    }


    private fun getSingleQuote(id : String) {
        singleQuoteData.tryEmit(NetworkUIState.Loading())
        Log.d("DetailVM", "getSingleQuote: Loading")
        viewModelScope.launch {
            try {

                //Using onEach
//                getSingleQuoteUseCase(id = id).onEach {
//                    singleQuoteData.tryEmit(NetworkUIState.Success(it))
//                    Log.d("DetailVM", "getSingleQuote: Success ${it.id}")
//                }.launchIn(viewModelScope)

                //Better using Collect for data flow
                getSingleQuoteUseCase(id = id).collect {
                    singleQuoteData.tryEmit(NetworkUIState.Success(it))
                    Log.d("DetailVM", "getSingleQuote: Success ${it.id}")
                }


                /** TODO - NOTE FOR Collect and onEach
                when using onEach must followed by launchIn(viewModelScope)
                Better using collect than onEach
                onEach is for debugging or for side effect
                collect is for data flow
                **/

            }catch (e: Exception){
                Log.d("DetailVM", "getSingleQuote: error ${e.message}")
                singleQuoteData.emit(NetworkUIState.Error(e.message ?: "Unknown error"))
            }
        }
    }
}