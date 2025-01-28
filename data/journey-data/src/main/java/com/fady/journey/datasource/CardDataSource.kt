package com.fady.journey.datasource

import com.fady.journey.model.CardDataModel

interface CardDataSource {
    suspend fun getCards(): List<CardDataModel>
}
