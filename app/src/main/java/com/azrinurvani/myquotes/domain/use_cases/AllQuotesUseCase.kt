package com.azrinurvani.myquotes.domain.use_cases

import com.azrinurvani.myquotes.domain.repository.QuotesRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AllQuotesUseCase @Inject constructor(
    private val quotesRepository: QuotesRepository
) {
    operator fun invoke() = flow {
        quotesRepository.getAllQuotes().let {
            if (it.isSuccessful) {
                emit(it.body()?.quotes)
            }
        }
    }
}