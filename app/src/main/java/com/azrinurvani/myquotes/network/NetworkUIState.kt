package com.azrinurvani.myquotes.network

sealed class NetworkUIState<T>{
    class Loading<T> : NetworkUIState<T>()
    data class Success<T>(val data : T?) : NetworkUIState<T>()
    data class Error<T>(val message : String) : NetworkUIState<T>()

}