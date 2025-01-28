package com.fady.journey.di

import com.fady.journey.repo.CardRepoImpl
import com.fady.journey.repos.CardRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface CardReposModule {
    @Binds
    fun bindsCardRepo(repo: CardRepoImpl): CardRepo
}
