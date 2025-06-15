package com.azrinurvani.myquotes.data.repository_impl

import com.azrinurvani.myquotes.data.remote.ApiInterface
import com.azrinurvani.myquotes.domain.models.AllQuotesResponseDto
import com.azrinurvani.myquotes.domain.models.QuotesDto
import com.azrinurvani.myquotes.domain.repository.QuotesRepository
import retrofit2.Response
import javax.inject.Inject

class QuotesRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
) : QuotesRepository {
    override suspend fun getAllQuotes(): Response<AllQuotesResponseDto> {
        return apiInterface.getAllQuotes()
    }

    override suspend fun getRandomQuote(): Response<QuotesDto> {
        return apiInterface.getRandomQuote()
    }
}