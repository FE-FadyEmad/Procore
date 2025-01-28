package com.fady.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


internal fun retrofitInstance(
    baseUrl: String,
    httpClient: OkHttpClient,
): Retrofit =
    Retrofit
        .Builder()
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder()
                    .enableComplexMapKeySerialization()
                    .create(),
            ),
        ).baseUrl(baseUrl)
        .client(httpClient)
        .build()