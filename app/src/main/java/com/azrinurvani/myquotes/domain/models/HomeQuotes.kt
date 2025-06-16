package com.azrinurvani.myquotes.domain.models

data class HomeQuotes(
    val randomQuotes : QuotesDto? = null,
    val allQuotes : List<QuotesDto?>? = null
)
