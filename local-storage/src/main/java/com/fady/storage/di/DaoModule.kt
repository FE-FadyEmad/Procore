package com.fady.storage.di

import com.fady.storage.database.AppDatabase
import com.fady.storage.database.DAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Singleton
    @Provides
    fun provideDAO(appDatabase: AppDatabase): DAO = appDatabase.getDao()
}
