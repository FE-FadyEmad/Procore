package com.fady.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthNetworkModule {
    @Provides
    @Singleton
    @AuthHttpClient
    fun provideOkHttpClient(tokenProvider: Provider<String>): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(InterceptorHeaderAuthorization(tokenProvider))
            .build()

    @Singleton
    @Provides
    @AuthRetrofit
    fun provideRetrofitFactory(
        @AuthHttpClient httpClient: OkHttpClient,
        @BaseUrl baseUrl: String,
    ): Retrofit = retrofitInstance(baseUrl, httpClient)
}
