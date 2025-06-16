package com.azrinurvani.myquotes.domain.use_cases

import android.util.Log
import com.azrinurvani.myquotes.domain.repository.QuotesRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllQuotesUseCase @Inject constructor(
    private val quotesRepository: QuotesRepository
) {
    operator fun invoke() = flow {
        val response = quotesRepository.getAllQuotes()
        if (response.isSuccessful){
            val quotes = response.body()?.quotes
            if (quotes != null) {
                emit(quotes)
                Log.d("AllQuotesUseCase", "quotes data: $quotes")
            } else {
                throw Exception("Quotes data is null")
            }
        }else {
            throw Exception("API failed: ${response.message()}")
        }
    }
}