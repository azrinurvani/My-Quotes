package com.azrinurvani.myquotes.domain.repository

import com.azrinurvani.myquotes.domain.models.AllQuotesResponseDto
import com.azrinurvani.myquotes.domain.models.QuotesDto
import retrofit2.Response

interface QuotesRepository {

    suspend fun getAllQuotes() : Response<AllQuotesResponseDto>

    suspend fun getRandomQuote() : Response<QuotesDto>

    suspend fun getSingleQuote(id : String) : Response<QuotesDto>
}