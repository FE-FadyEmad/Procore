package com.fady.storage.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.fady.storage.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {
    @Provides
    @Singleton
    @DataBaseName
    fun provideDatabaseName(): String = "proCoreDatabase"

    @Provides
    @Singleton
    @SharedPrefName
    fun provideSharedPrefName(): String = "proCoreShared"

    @Singleton
    @Provides
    fun provideDataBase(
        @ApplicationContext context: Context,
        @DataBaseName name: String,
    ): AppDatabase =
        Room
            .databaseBuilder(
                context,
                AppDatabase::class.java,
                name,
            ).build()

    @Provides
    fun provideSharedPreference(
        @ApplicationContext context: Context,
        @SharedPrefName prefName: String,
    ): SharedPreferences =
        EncryptedSharedPreferences.create(
            prefName,
            MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
        )
}
