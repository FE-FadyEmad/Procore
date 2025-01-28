package com.fady.network

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NonAuthNetworkModule {
    @Provides
    @Singleton
    @NonAuthHttpClient
    fun provideNonAuthOkHttpClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .build()

    @Singleton
    @Provides
    @NonAuthRetrofit
    fun provideNonAuthRetrofitFactory(
        @NonAuthHttpClient httpClient: OkHttpClient,
        @BaseUrl baseUrl: String,
    ): Retrofit = retrofitInstance(baseUrl, httpClient)

}
