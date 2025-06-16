package com.azrinurvani.myquotes.data.remote

import com.azrinurvani.myquotes.domain.models.AllQuotesResponseDto
import com.azrinurvani.myquotes.domain.models.QuotesDto
import com.azrinurvani.myquotes.network.ALL_QUOTES
import com.azrinurvani.myquotes.network.GET_SINGLE_QUOTES
import com.azrinurvani.myquotes.network.RANDOM_QUOTES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET(ALL_QUOTES)
    suspend fun getAllQuotes() : Response<AllQuotesResponseDto>


    @GET(RANDOM_QUOTES)
    suspend fun getRandomQuote() : Response<QuotesDto>

    @GET(GET_SINGLE_QUOTES)
    suspend fun getSingleQuotes(
        @Path("id") id : String
    ) : Response<QuotesDto>
}