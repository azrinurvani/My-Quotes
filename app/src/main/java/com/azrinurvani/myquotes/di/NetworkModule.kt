package com.azrinurvani.myquotes.di

import android.content.Context
import android.util.Log

import com.azrinurvani.myquotes.BuildConfig
import com.azrinurvani.myquotes.common.K
import com.azrinurvani.myquotes.data.remote.ApiInterface
import com.azrinurvani.myquotes.network.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Named
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
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
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message ->
            Log.d(K.API_LOG_NAME, message)
        }.apply {
            level =
                if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
        }
    }


    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        @ApplicationContext context: Context
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {
//            if(BuildConfig.DEBUG) addInterceptor(ChuckerInterceptor(context))
        }
            .connectTimeout(30, TimeUnit.SECONDS)
            .callTimeout(45, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(@Named("base_url") baseUrl : String,client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiInterface(retrofit: Retrofit) : ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }


}