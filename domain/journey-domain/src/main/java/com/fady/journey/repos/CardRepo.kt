package com.fady.journey.repos

import com.fady.journey.model.CardDomainModel

interface CardRepo {
    suspend fun getCards(): List<CardDomainModel>
}
