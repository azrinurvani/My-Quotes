package com.azrinurvani.myquotes.domain.models

import com.google.gson.annotations.SerializedName

data class AllQuotesResponseDto(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("skip")
	val skip: Int? = null,

	@field:SerializedName("quotes")
	val quotes: List<QuotesDto?>? = null
)

data class QuotesDto(

	@field:SerializedName("quote", alternate = ["message"])
	val quote: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)
