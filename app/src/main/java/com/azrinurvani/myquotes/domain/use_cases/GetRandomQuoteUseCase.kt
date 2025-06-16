package com.azrinurvani.myquotes.domain.use_cases

import com.azrinurvani.myquotes.domain.models.QuotesDto
import com.azrinurvani.myquotes.domain.repository.QuotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuotesRepository
){
    operator fun invoke(): Flow<QuotesDto> = flow {
        val response = repository.getRandomQuote()

        if (response.isSuccessful && response.body() != null) {
            emit(response.body()!!)
        } else {
            throw Exception("Random quote failed with code ${response.code()}")
        }
    }

}