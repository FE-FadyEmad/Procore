package com.fady.journey.di

import com.fady.journey.datasource.CardDataSource
import com.fady.journey.datasource.RemoteCardDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CardDataSourcesModule {
    @Binds
    fun bindsCardDataSource(dataSource: RemoteCardDataSource): CardDataSource
}
