package com.fady.journey.datasource

import com.fady.journey.apiservices.ApiService
import com.fady.journey.model.CardDataModel
import javax.inject.Inject

class RemoteCardDataSource
    @Inject
    constructor(
        private val apiService: ApiService,
    ) : CardDataSource {
        override suspend fun getCards(): List<CardDataModel> {
            try {
                val s = apiService.getCards().data
                return s
            } catch (e: Exception) {
                throw e
            }
        }
    }
