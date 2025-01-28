package com.fady.journey.di

import com.fady.journey.apiservices.ApiService
import com.fady.network.NonAuthRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CardModule {
    @Provides
    @Singleton
    fun getApiService(
        @NonAuthRetrofit retrofit: Retrofit,
    ): ApiService = retrofit.create(ApiService::class.java)
}
