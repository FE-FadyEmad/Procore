package com.fady.journey.apiservices

import com.fady.journey.model.ResponseDateModel
import retrofit2.http.GET

interface ApiService {
    @GET("cards")
    suspend fun getCards(): ResponseDateModel
}
