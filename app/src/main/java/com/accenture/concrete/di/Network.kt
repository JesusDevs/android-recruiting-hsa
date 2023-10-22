package com.accenture.concrete.di

import com.accenture.concrete.constant.ServiceConstants.API_ENDPOINT
import com.accenture.concrete.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

object Network {
    @Module
    @InstallIn(SingletonComponent::class)
    object NetworkModule {

        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
        }

        @Singleton
        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Singleton
        @Provides
        fun provideApiClient(retrofit: Retrofit): ApiService {
            return retrofit.create(ApiService::class.java)
        }
    }

}