package com.fady.auth

import android.content.SharedPreferences
import com.fady.network.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    @BaseUrl
    fun provideBaseUrl(): String = "https://api.pokemontcg.io/v2/"

    @Provides
    @Singleton
    fun provideTokenProvider(sharedPreferences: SharedPreferences): String {
        sharedPreferences.edit().putString(
            "token",
            "TOKEN_VALUE",
        ).apply()
        return sharedPreferences.getString("token", "NO_TOKEN_SAVED").orEmpty()
    }
}
