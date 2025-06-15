package com.azrinurvani.myquotes.di

import com.azrinurvani.myquotes.data.remote.ApiInterface
import com.azrinurvani.myquotes.network.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Named
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @Named("base_url")
    fun provideBaseUrl() : String = BASE_URL

    @Singleton
    @Provides
    @Named("base_url_2")
    fun provideBaseUrl2() : String = BASE_URL

    @Singleton
    @Provides
    fun provideRetrofitBuilder(@Named("base_url") baseUrl : String) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit) : ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }


}