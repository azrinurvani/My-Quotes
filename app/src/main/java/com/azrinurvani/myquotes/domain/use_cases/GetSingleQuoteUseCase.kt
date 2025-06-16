package com.azrinurvani.myquotes.domain.use_cases

import android.util.Log
import com.azrinurvani.myquotes.domain.repository.QuotesRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSingleQuoteUseCase @Inject constructor(
    private val repository: QuotesRepository
) {
    operator fun invoke(id : String) = flow {
        val response = repository.getSingleQuote(id = id)
        Log.d("GetSingleQuoteUseCase", "response ${response.code()}")

        if (response.isSuccessful && response.body() != null) {
            emit(response.body()!!)
        } else {
            throw Exception("Single quote failed with code ${response.code()}")
        }
    }
}