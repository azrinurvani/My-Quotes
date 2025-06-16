package com.azrinurvani.myquotes.presentation.screens.home_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azrinurvani.myquotes.domain.models.HomeQuotes
import com.azrinurvani.myquotes.domain.models.QuotesDto
import com.azrinurvani.myquotes.domain.use_cases.AllQuotesUseCase
import com.azrinurvani.myquotes.domain.use_cases.RandomQuoteUseCase
import com.azrinurvani.myquotes.network.NetworkUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val allQuotesUseCase: AllQuotesUseCase,
    private val randomQuoteUseCase: RandomQuoteUseCase
) : ViewModel(){

    var quotesData = MutableStateFlow<NetworkUIState<HomeQuotes>>(NetworkUIState.Loading()) //this is getter
        private set //this is setter

    //same like this
//    private val _quotesData = MutableStateFlow<NetworkUIState>(NetworkUIState.Loading)
//    val quotesData : StateFlow<NetworkUIState> = _quotesData.asStateFlow()

    init {
        getQuotes()
    }

    //fetch separately
//    private fun getQuotes(){
//        viewModelScope.launch {
//            try {
//                quotesData.emit(NetworkUIState.Loading())
//
//                randomQuoteUseCase()
//                    .onEach { Log.d("HomeViewModel", "RandomQuote emitted: $it") }
//
//                val allQuotes = allQuotesUseCase().first()
//                val randomQuote = randomQuoteUseCase().first()
//
//                quotesData.emit(
//                    NetworkUIState.Success(
//                        HomeQuotes(
//                            randomQuotes = randomQuote,
//                            allQuotes = allQuotes
//                        )
//                    )
//                )
//            } catch (e: Exception) {
//                quotesData.emit(NetworkUIState.Error(e.message ?: "Unknown error"))
//            }
//        }
//    }


    //fetch using combine
    private fun getQuotes(){
        val allQuotesFlow = allQuotesUseCase()
            .onEach { Log.d("HomeViewModel", "AllQuotes emitted: $it") }

        val randomQuoteFlow = randomQuoteUseCase()
            .onEach { Log.d("HomeViewModel", "RandomQuote emitted: $it") }

        allQuotesFlow
            .combine(randomQuoteFlow) { allQuotes, randomQuote ->
                Log.d("HomeViewModel", "Combine triggered")
                NetworkUIState.Success(
                    HomeQuotes(
                        randomQuotes = randomQuote,
                        allQuotes = allQuotes
                    )
                )
            }
            .onStart {
                Log.d("HomeViewModel", "onStart - Loading")
                quotesData.emit(NetworkUIState.Loading())
            }
            .catch { e ->
                Log.e("HomeViewModel", "Error caught: ${e.message}")
                quotesData.emit(NetworkUIState.Error(e.message ?: "Unknown error"))
            }
            .onEach { result -> //this result is NetworkUIState.Success when fetch using combine
                Log.d("HomeViewModel", "Emitting result: $result")
                quotesData.emit(result)
            }
            .launchIn(viewModelScope)
    }


//    private fun getQuotes() {
//        quotesData.tryEmit(NetworkUIState.Loading())
//        allQuotesUseCase().combine(randomQuoteUseCase()){ quotesList: List<QuotesDto?>?, randomQuote: QuotesDto? ->
//            quotesData.tryEmit(NetworkUIState.Success(HomeQuotes(randomQuotes = randomQuote, allQuotes = quotesList)))
//        }.launchIn(viewModelScope)
//    }
}