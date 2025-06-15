package com.azrinurvani.myquotes.di

import com.azrinurvani.myquotes.data.remote.ApiInterface
import com.azrinurvani.myquotes.data.repository_impl.QuotesRepositoryImpl
import com.azrinurvani.myquotes.domain.repository.QuotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideQuotesRepository(
        apiInterface: ApiInterface
    ) : QuotesRepository{
        return QuotesRepositoryImpl(apiInterface)
    }
}