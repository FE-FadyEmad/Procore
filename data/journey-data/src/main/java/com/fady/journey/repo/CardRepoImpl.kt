package com.fady.journey.repo

import com.fady.journey.datasource.CardDataSource
import com.fady.journey.mapper.toDomainModel
import com.fady.journey.model.CardDomainModel
import com.fady.journey.repos.CardRepo
import javax.inject.Inject

class CardRepoImpl
    @Inject
    constructor(
        private val dataSource: CardDataSource,
    ) : CardRepo {
        override suspend fun getCards(): List<CardDomainModel> {
            try {
                val s = dataSource.getCards().map { it.toDomainModel() }
                return s
            } catch (e: Exception) {
                throw e
            }
        }
    }
